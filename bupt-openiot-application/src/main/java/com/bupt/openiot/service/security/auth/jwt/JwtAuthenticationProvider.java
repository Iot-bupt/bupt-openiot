package com.bupt.openiot.service.security.auth.jwt;

import com.bupt.openiot.service.security.auth.JwtAuthenticationToken;
import com.bupt.openiot.service.security.model.SecurityUser;
import com.bupt.openiot.service.security.model.token.JwtTokenFactory;
import com.bupt.openiot.service.security.model.token.RawAccessJwtToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
@SuppressWarnings("unchecked")
public class JwtAuthenticationProvider implements AuthenticationProvider {

    private final JwtTokenFactory tokenFactory;

    @Autowired
    public JwtAuthenticationProvider(JwtTokenFactory tokenFactory) {
        this.tokenFactory = tokenFactory;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        RawAccessJwtToken rawAccessToken = (RawAccessJwtToken) authentication.getCredentials();
        SecurityUser securityUser = tokenFactory.parseAccessJwtToken(rawAccessToken);
        return new JwtAuthenticationToken(securityUser);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (JwtAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
