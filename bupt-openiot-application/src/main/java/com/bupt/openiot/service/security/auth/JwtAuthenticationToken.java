package com.bupt.openiot.service.security.auth;


import com.bupt.openiot.service.security.model.SecurityUser;
import com.bupt.openiot.service.security.model.token.RawAccessJwtToken;

public class JwtAuthenticationToken extends AbstractJwtAuthenticationToken {

    private static final long serialVersionUID = -8487219769037942225L;

    public JwtAuthenticationToken(RawAccessJwtToken unsafeToken) {
        super(unsafeToken);
    }

    public JwtAuthenticationToken(SecurityUser securityUser) {
        super(securityUser);
    }
}
