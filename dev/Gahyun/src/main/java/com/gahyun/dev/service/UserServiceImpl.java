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
        // passwordEncoder�� ����� �κ��� �����ϰų� ��й�ȣ�� ���� ��
        // return passwordEncoder.matches(password, storedPassword);
        
        UserDto user = userDao.getUserByUserid(userid);
        if (user != null && user.getPassword().equals(password)) {
            return user;  // ��й�ȣ�� ������ ����� ��ü ��ȯ
        }
        return null;  // Ʋ���� null ��ȯ
    }

    @Override
    public UserDto getUserByUserid(String userid) {
        // UserDao���� ����ڸ� ��ȸ�ϴ� ���� ȣ��
        return userDao.getUserByUserid(userid);
    }
}