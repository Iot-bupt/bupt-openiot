package com.bupt.openiot.dao.user;

import com.bupt.openiot.common.data.User;
import com.bupt.openiot.common.data.id.UserId;
import com.bupt.openiot.common.data.security.UserCredentials;
import com.bupt.openiot.dao.mapper.UserCredentialsMapper;
import com.bupt.openiot.dao.mapper.UserMapper;
import com.bupt.openiot.dao.service.Validator;
import com.bupt.openiot.dao.util.ModelConvertUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    /*@Autowired
    private UserMapper userMapper;*/

    @Autowired
    private UserCredentialsMapper userCredentialsMapper;

    @Override
    public List<User> getAll() {
        List<User> res = new ArrayList<User>();
       /* List<com.bupt.openiot.dao.model.User> users = userMapper.selectAll();*/
        List<com.bupt.openiot.dao.model.User> users = new ArrayList<com.bupt.openiot.dao.model.User>();
        for (com.bupt.openiot.dao.model.User user : users) {
            res.add(ModelConvertUtils.convertUser(user));
        }
        return res;
    }

    @Override
    public User findUserByEmail(String email) {
        LOGGER.trace("Executing findUserByEmail [{}]", email);
        Validator.validateString(email, "Incorrect email " + email);
        com.bupt.openiot.dao.model.User queryUser = new com.bupt.openiot.dao.model.User();
        queryUser.setEmail(email);
        /*com.bupt.openiot.dao.model.User user = userMapper.selectOne(queryUser);*/
        com.bupt.openiot.dao.model.User user = new com.bupt.openiot.dao.model.User();
        return ModelConvertUtils.convertUser(user);
    }

    @Override
    public User findUserById(UserId userId) {
        LOGGER.trace("Executing findUserById [{}]", userId);
        Validator.validateId(userId, "Incorrect userId " + userId);
        com.bupt.openiot.dao.model.User queryUser = new com.bupt.openiot.dao.model.User();
        queryUser.setId(userId.getId().toString());
        /*com.bupt.openiot.dao.model.User user = userMapper.selectOne(queryUser);*/
        com.bupt.openiot.dao.model.User user = new com.bupt.openiot.dao.model.User();
        return ModelConvertUtils.convertUser(user);
    }

    @Override
    public UserCredentials findUserCredentialsByUserId(UserId userId) {
        com.bupt.openiot.dao.model.UserCredentials queryUserCredentials =
                new com.bupt.openiot.dao.model.UserCredentials();
        queryUserCredentials.setUserId(userId.getId().toString());
        com.bupt.openiot.dao.model.UserCredentials userCredentials = userCredentialsMapper.selectOne(queryUserCredentials);
        return ModelConvertUtils.convertUserCredentials(userCredentials);
    }
}
