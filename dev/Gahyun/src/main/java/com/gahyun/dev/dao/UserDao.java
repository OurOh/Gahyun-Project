package com.gahyun.dev.dao;

import java.util.List;
import com.gahyun.dev.model.UserDto;

public interface UserDao {
    List<UserDto> getAllUser();
    UserDto getUser(int id);
    UserDto getUserByUserid(String userid);  // userid�� ����� ��ȸ
    void insertUser(UserDto dto);  // ����� ���� ����
    
    void updateUser(UserDto dto);
    void delUser(int id);
}
