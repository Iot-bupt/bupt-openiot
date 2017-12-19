package com.bupt.openiot.service.security.auth.rest;

import com.bupt.openiot.common.data.User;
import com.bupt.openiot.common.data.security.UserCredentials;
import com.bupt.openiot.dao.user.UserService;
import com.bupt.openiot.service.security.model.SecurityUser;
import com.bupt.openiot.common.data.security.Authority;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class RestAuthenticationProvider implements AuthenticationProvider {

    private final BCryptPasswordEncoder encoder;
    private final UserService userService;

    @Autowired
    public RestAuthenticationProvider(final UserService userService, final BCryptPasswordEncoder encoder) {
        this.userService = userService;
        this.encoder = encoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        Assert.notNull(authentication, "No authentication data provided");

        String username = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();

        //User user = userService.findUserByEmail(username);
        User user = new User();
        //获取用户角色,此处设为admin
        user.setAuthority(Authority.SYS_ADMIN);
       
        if (user == null) {
            throw new UsernameNotFoundException("User not found: " + username);
        }

        //UserCredentials userCredentials = userService.findUserCredentialsByUserId(user.getId());
        UserCredentials userCredentials = new UserCredentials();
        if (userCredentials == null) {
            throw new UsernameNotFoundException("User credentials not found");
        }
        userCredentials.setEnabled(true);

        if (!userCredentials.isEnabled()) {
            throw new DisabledException("User is not active");
        }
       
       /* if (!encoder.matches(password, userCredentials.getPassword())) {
            throw new BadCredentialsException("Authentication Failed. Username or Password not valid.");
        }*/

       // if (user.getAuthority() == null) throw new InsufficientAuthenticationException("User has no authority assigned");

        SecurityUser securityUser = new SecurityUser(user, userCredentials.isEnabled());
    	//SecurityUser securityUser = new SecurityUser(new User(), new Boolean(true));

        return new UsernamePasswordAuthenticationToken(securityUser, null, securityUser.getAuthorities());

        
    }

    @Override 
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
