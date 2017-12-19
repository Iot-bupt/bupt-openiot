package com.bupt.openiot.dao.util;

import com.bupt.openiot.common.data.User;
import com.bupt.openiot.common.data.id.CustomerId;
import com.bupt.openiot.common.data.id.TenantId;
import com.bupt.openiot.common.data.id.UserCredentialsId;
import com.bupt.openiot.common.data.id.UserId;
import com.bupt.openiot.common.data.security.Authority;
import com.bupt.openiot.common.data.security.UserCredentials;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.UUID;

/**
 *
 * Created by dy on 2017/4/24.
 */
public class ModelConvertUtils {

    /**
     * 将数据库表对应的User转换为通用User
     * @param user
     * @return
     */
    public static User convertUser(com.bupt.openiot.dao.model.User user) {
        User securyUser = null;
        if (user != null) {
            securyUser = new User();
            ObjectMapper mapper = new ObjectMapper();
            securyUser.setId(new UserId(UUID.fromString(user.getId())));
            securyUser.setTenantId(new TenantId(UUID.fromString(user.getTenantId())));
            securyUser.setCustomerId(new CustomerId(UUID.fromString(user.getCustomerId())));
            securyUser.setEmail(user.getEmail());
            securyUser.setAuthority(Authority.parse(user.getAuthority()));
            securyUser.setFirstName(user.getFirstName());
            securyUser.setLastName(user.getLastName());
            if (user.getAdditionalInfo() != null) {
                try {
                    securyUser.setAdditionalInfo(mapper.readTree(user.getAdditionalInfo()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            securyUser.setCreatedTime(UUID.fromString(user.getId()).timestamp());
        }

        return securyUser;
    }

    /**
     * 将数据库表对应的UserCredentials转换为通用UserCredentials
     * @param userCredentials
     * @return
     */
    public static UserCredentials convertUserCredentials(com.bupt.openiot.dao.model.UserCredentials userCredentials) {
        UserCredentials securyUserCredentials = null;
        if (userCredentials != null) {
            securyUserCredentials = new UserCredentials();
            securyUserCredentials.setId(new UserCredentialsId(UUID.fromString(userCredentials.getId())));
            securyUserCredentials.setUserId(new UserId(UUID.fromString(userCredentials.getUserId())));
            securyUserCredentials.setEnabled(userCredentials.getEnabled());
            securyUserCredentials.setPassword(userCredentials.getPassword());
            securyUserCredentials.setActivateToken(userCredentials.getActivateToken());
            securyUserCredentials.setResetToken(userCredentials.getResetToken());
            securyUserCredentials.setCreatedTime(UUID.fromString(userCredentials.getId()).timestamp());
        }

        return securyUserCredentials;
    }

}
