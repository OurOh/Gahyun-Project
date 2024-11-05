package com.gahyun.dev.dao;



import org.springframework.stereotype.Repository;

import com.gahyun.dev.model.UserDto;


@Repository
public interface UserDao {
    UserDto getUserByUserId(String userid);	 // MySQL에서 사용자 정보 조회
    void updateUser(UserDto user);  // 사용자 정보를 MySQL에 업데이트
    void insertUser(UserDto user);  // 사용자 정보를 MySQL에 삽입
    
    String findUserIdByNameAndEmail(String name, String email);
    void resetPassword(String email, String userid);
    
    // 아이디 중복 체크 메서드 추가
    boolean isUserIdExists(String userid);
}
