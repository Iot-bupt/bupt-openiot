package com.bupt.openiot.service.security.auth.jwt;

import com.bupt.openiot.service.security.model.SecurityUser;
import com.bupt.openiot.service.security.model.token.JwtToken;
import com.bupt.openiot.service.security.model.token.JwtTokenFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RefreshTokenRepository {

    private final JwtTokenFactory tokenFactory;

    @Autowired
    public RefreshTokenRepository(final JwtTokenFactory tokenFactory) {
        this.tokenFactory = tokenFactory;
    }

    public JwtToken requestRefreshToken(SecurityUser user) {
        return tokenFactory.createRefreshToken(user);
    }

}
