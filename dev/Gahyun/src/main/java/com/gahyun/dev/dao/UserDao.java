package com.gahyun.dev.dao;



import com.gahyun.dev.model.UserDto;



public interface UserDao {
    UserDto getUserByUserId(String userid);	 // MySQL에서 사용자 정보 조회
    void updateUser(UserDto user);  // 사용자 정보를 MySQL에 업데이트
    void insertUser(UserDto user);  // 사용자 정보를 MySQL에 삽입
}
