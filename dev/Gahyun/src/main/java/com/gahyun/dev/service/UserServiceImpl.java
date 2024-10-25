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
    
    
    @Override
    public void updateUser(UserDto user) {
        userDao.updateUser(user);  // DAO를 통해 사용자 정보 업데이트
    }
    
    @Override
    public void insertUser(UserDto user) {
        // 사용자 정보를 데이터베이스에 삽입
        userDao.insertUser(user);
    }
    
}
