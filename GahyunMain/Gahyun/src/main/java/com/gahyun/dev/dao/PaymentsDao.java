package com.gahyun.dev.dao;

import java.util.List;

import com.gahyun.dev.model.UserDto;



public interface PaymentsDao {
  List<UserDto> getAllUser();
  UserDto getUser(int id);
  void insertUser(UserDto dto);
  void updateUser(UserDto dto);
  void delUser(int id);
}
