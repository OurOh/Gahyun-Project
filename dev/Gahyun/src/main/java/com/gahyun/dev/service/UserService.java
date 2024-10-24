package com.gahyun.dev.service;

import com.gahyun.dev.model.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    // 기존 메서드
    UserDto authenticate(String userid, String password);  // 사용자 인증 메서드

    void insertUser(UserDto user);  // 회원가입 메서드

    void updateUser(UserDto user);  // 사용자 정보를 업데이트하는 메서드
}
