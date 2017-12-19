package com.bupt.openiot.service.security.model.token;

import com.bupt.openiot.common.data.id.CustomerId;
import com.bupt.openiot.common.data.id.TenantId;
import com.bupt.openiot.common.data.id.UserId;
import com.bupt.openiot.common.data.security.Authority;
import com.bupt.openiot.conf.JwtSettings;
import com.bupt.openiot.service.security.model.SecurityUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class JwtTokenFactory {

    private static final String SCOPES = "scopes";
    private static final String USER_ID = "userId";
    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";
    private static final String ENABLED = "enabled";
    private static final String TENANT_ID = "tenantId";
    private static final String CUSTOMER_ID = "customerId";

    private final JwtSettings settings;

    @Autowired
    public JwtTokenFactory(JwtSettings settings) {
        this.settings = settings;
    }

    /**
     * Factory method for issuing new JWT Tokens.
     */
    public AccessJwtToken createAccessJwtToken(SecurityUser securityUser) {
        if (StringUtils.isBlank(securityUser.getEmail()))
            throw new IllegalArgumentException("Cannot create JWT Token without username/email");

        if (securityUser.getAuthority() == null)
            throw new IllegalArgumentException("User doesn't have any privileges");

        Claims claims = Jwts.claims().setSubject(securityUser.getEmail());
    	
        claims.put(SCOPES, securityUser.getAuthorities().stream().map(s -> s.getAuthority()).collect(Collectors.toList()));
        claims.put(USER_ID, securityUser.getId().getId().toString());
        claims.put(FIRST_NAME, securityUser.getFirstName());
        claims.put(LAST_NAME, securityUser.getLastName());
        claims.put(ENABLED, securityUser.isEnabled());
        if (securityUser.getTenantId() != null) {
            claims.put(TENANT_ID, securityUser.getTenantId().getId().toString());
        }
        if (securityUser.getCustomerId() != null) {
            claims.put(CUSTOMER_ID, securityUser.getCustomerId().getId().toString());
        }

        DateTime currentTime = new DateTime();

        String token = Jwts.builder()
                .setClaims(claims)
                .setIssuer(settings.getTokenIssuer())
                .setIssuedAt(currentTime.toDate())
                .setExpiration(currentTime.plusSeconds(settings.getTokenExpirationTime()).toDate())
                .signWith(SignatureAlgorithm.HS512, settings.getTokenSigningKey())
                .compact();

        return new AccessJwtToken(token, claims);
    }

    public SecurityUser parseAccessJwtToken(RawAccessJwtToken rawAccessToken) {
        Jws<Claims> jwsClaims = rawAccessToken.parseClaims(settings.getTokenSigningKey());
        Claims claims = jwsClaims.getBody();
        String subject = claims.getSubject();
        List<String> scopes = claims.get(SCOPES, List.class);
        if (scopes == null || scopes.isEmpty()) {
            throw new IllegalArgumentException("JWT Token doesn't have any scopes");
        }

        SecurityUser securityUser = new SecurityUser(new UserId(UUID.fromString(claims.get(USER_ID, String.class))));
        securityUser.setEmail(subject);
        securityUser.setAuthority(Authority.parse(scopes.get(0)));
        securityUser.setFirstName(claims.get(FIRST_NAME, String.class));
        securityUser.setLastName(claims.get(LAST_NAME, String.class));
        securityUser.setEnabled(claims.get(ENABLED, Boolean.class));
        String tenantId = claims.get(TENANT_ID, String.class);
        if (tenantId != null) {
            securityUser.setTenantId(new TenantId(UUID.fromString(tenantId)));
        }
        String customerId = claims.get(CUSTOMER_ID, String.class);
        if (customerId != null) {
            securityUser.setCustomerId(new CustomerId(UUID.fromString(customerId)));
        }

        return securityUser;
    }

    public JwtToken createRefreshToken(SecurityUser securityUser) {
        if (StringUtils.isBlank(securityUser.getEmail())) {
            throw new IllegalArgumentException("Cannot create JWT Token without username/email");
        }

        DateTime currentTime = new DateTime();

        Claims claims = Jwts.claims().setSubject(securityUser.getEmail());
        claims.put(SCOPES, Arrays.asList(Authority.REFRESH_TOKEN.name()));
        claims.put(USER_ID, securityUser.getId().getId().toString());

        String token = Jwts.builder()
                .setClaims(claims)
                .setIssuer(settings.getTokenIssuer())
                .setId(UUID.randomUUID().toString())
                .setIssuedAt(currentTime.toDate())
                .setExpiration(currentTime.plusSeconds(settings.getRefreshTokenExpTime()).toDate())
                .signWith(SignatureAlgorithm.HS512, settings.getTokenSigningKey())
                .compact();

        return new AccessJwtToken(token, claims);
    }

    public SecurityUser parseRefreshToken(RawAccessJwtToken rawAccessToken) {
        Jws<Claims> jwsClaims = rawAccessToken.parseClaims(settings.getTokenSigningKey());
        Claims claims = jwsClaims.getBody();
        String subject = claims.getSubject();
        List<String> scopes = claims.get(SCOPES, List.class);
        if (scopes == null || scopes.isEmpty()) {
            throw new IllegalArgumentException("Refresh Token doesn't have any scopes");
        }
        if (!scopes.get(0).equals(Authority.REFRESH_TOKEN.name())) {
            throw new IllegalArgumentException("Invalid Refresh Token scope");
        }
        SecurityUser securityUser = new SecurityUser(new UserId(UUID.fromString(claims.get(USER_ID, String.class))));
        securityUser.setEmail(subject);
        return securityUser;
    }

}
