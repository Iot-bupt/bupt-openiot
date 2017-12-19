package com.bupt.openiot.service.security.auth;

import com.bupt.openiot.service.security.model.SecurityUser;
import com.bupt.openiot.service.security.model.token.RawAccessJwtToken;

public class RefreshAuthenticationToken extends AbstractJwtAuthenticationToken {

    private static final long serialVersionUID = -1311042791508924523L;

    public RefreshAuthenticationToken(RawAccessJwtToken unsafeToken) {
        super(unsafeToken);
    }

    public RefreshAuthenticationToken(SecurityUser securityUser) {
        super(securityUser);
    }
}
