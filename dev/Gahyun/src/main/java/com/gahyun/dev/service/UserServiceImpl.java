package com.gahyun.dev.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.gahyun.dev.dao.UserDao;
import com.gahyun.dev.model.UserDto;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDto authenticate(String userid, String password) {
        // passwordEncoder를 사용한 부분을 제외하거나 비밀번호를 직접 비교
        // return passwordEncoder.matches(password, storedPassword);
        
        UserDto user = userDao.getUserByUserid(userid);
        if (user != null && user.getPassword().equals(password)) {
            return user;  // 비밀번호가 맞으면 사용자 객체 반환
        }
        return null;  // 틀리면 null 반환
    }

    @Override
    public UserDto getUserByUserid(String userid) {
        // UserDao에서 사용자를 조회하는 로직 호출
        return userDao.getUserByUserid(userid);
    }
}