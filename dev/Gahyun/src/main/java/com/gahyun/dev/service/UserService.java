package com.gahyun.dev.service;

import com.gahyun.dev.model.UserDto;

public interface UserService {
    UserDto authenticate(String userid, String password);
    
    void insertUser(UserDto user);  // 회원가입 메서드 추가
    void updateUser(UserDto user);  // 사용자 정보를 업데이트하는 메서드
    
}