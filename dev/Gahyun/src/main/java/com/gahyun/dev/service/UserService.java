package com.gahyun.dev.service;

import com.gahyun.dev.model.UserDto;

public interface UserService {
    UserDto authenticate(String userid, String password);
    
    void insertUser(UserDto user);  // ȸ������ �޼��� �߰�
    void updateUser(UserDto user);  // ����� ������ ������Ʈ�ϴ� �޼���
    
}