package com.gahyun.dev.dao;

import java.util.List;
import com.gahyun.dev.model.UserDto;

public interface UserDao {
    List<UserDto> getAllUser();
    UserDto getUser(int id);
    UserDto getUserByUserid(String userid);  // userid로 사용자 조회
    void insertUser(UserDto dto);  // 사용자 정보 삽입
    
    void updateUser(UserDto dto);
    void delUser(int id);
}
