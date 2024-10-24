package com.gahyun.dev.service;

import com.gahyun.dev.model.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    // ���� �޼���
    UserDto authenticate(String userid, String password);  // ����� ���� �޼���

    void insertUser(UserDto user);  // ȸ������ �޼���

    void updateUser(UserDto user);  // ����� ������ ������Ʈ�ϴ� �޼���
}
