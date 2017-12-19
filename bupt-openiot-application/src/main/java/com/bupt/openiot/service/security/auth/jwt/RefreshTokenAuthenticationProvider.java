package com.bupt.openiot.service.security.auth.jwt;

import com.bupt.openiot.common.data.User;
import com.bupt.openiot.common.data.security.UserCredentials;
import com.bupt.openiot.dao.user.UserService;
import com.bupt.openiot.service.security.auth.RefreshAuthenticationToken;
import com.bupt.openiot.service.security.model.SecurityUser;
import com.bupt.openiot.service.security.model.token.JwtTokenFactory;
import com.bupt.openiot.service.security.model.token.RawAccessJwtToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class RefreshTokenAuthenticationProvider implements AuthenticationProvider {

    private final JwtTokenFactory tokenFactory;
    private final UserService userService;

    @Autowired
    public RefreshTokenAuthenticationProvider(final UserService userService, final JwtTokenFactory tokenFactory) {
        this.userService = userService;
        this.tokenFactory = tokenFactory;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        Assert.notNull(authentication, "No authentication data provided");
        RawAccessJwtToken rawAccessToken = (RawAccessJwtToken) authentication.getCredentials();
        SecurityUser unsafeUser = tokenFactory.parseRefreshToken(rawAccessToken);

        User user = userService.findUserById(unsafeUser.getId());
        if (user == null) {
            throw new UsernameNotFoundException("User not found by refresh token");
        }

        UserCredentials userCredentials = userService.findUserCredentialsByUserId(user.getId());
        if (userCredentials == null) {
            throw new UsernameNotFoundException("User credentials not found");
        }

        if (!userCredentials.isEnabled()) {
            throw new DisabledException("User is not active");
        }

        if (user.getAuthority() == null) throw new InsufficientAuthenticationException("User has no authority assigned");

        SecurityUser securityUser = new SecurityUser(user, userCredentials.isEnabled());

        return new RefreshAuthenticationToken(securityUser);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (RefreshAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
