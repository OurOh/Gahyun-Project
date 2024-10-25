package com.gahyun.dev.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDto {
    
	 // Lombok으로 자동 생성되므로 명시적인 Getters and Setters는 필요하지 않음
    private String userid;
    private String password;
    private String name;
    private String phone_num;
    private String user_birth;  // 생년월일 필드

   
}
