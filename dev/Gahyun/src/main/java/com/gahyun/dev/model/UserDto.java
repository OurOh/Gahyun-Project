package com.gahyun.dev.model;

import java.sql.Timestamp;
import java.time.LocalDate;

import lombok.Data;

@Data
public class UserDto {

    private int user_id;        // 사용자 고유 ID
    private String name;        // 사용자 이름
    private String email;       // 이메일
    private String password;    // 비밀번호
    private String phone_num;   // 전화번호
    private Timestamp created_at; // 생성 시간
    private LocalDate user_birth; // 생년월일
    private String userid;      // 로그인 시 사용되는 아이디
    
}
