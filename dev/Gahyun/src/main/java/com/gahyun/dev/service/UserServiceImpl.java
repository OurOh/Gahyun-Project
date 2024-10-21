package com.gahyun.dev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gahyun.dev.dao.UserDao;
import com.gahyun.dev.model.UserDto;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDto authenticate(String userid, String password) {
        UserDto user = userDao.getUserByUserId(userid);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}
