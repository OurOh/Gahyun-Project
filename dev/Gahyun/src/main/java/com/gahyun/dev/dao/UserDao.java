package com.gahyun.dev.dao;



import com.gahyun.dev.model.UserDto;



public interface UserDao {
    UserDto getUserByUserId(String userid);	 // MySQL���� ����� ���� ��ȸ
    void updateUser(UserDto user);  // ����� ������ MySQL�� ������Ʈ
    void insertUser(UserDto user);  // ����� ������ MySQL�� ����
}
