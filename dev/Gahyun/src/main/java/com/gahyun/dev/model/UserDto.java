package com.gahyun.dev.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDto {
    
	 // Lombok���� �ڵ� �����ǹǷ� ������� Getters and Setters�� �ʿ����� ����
    private String userid;
    private String password;
    private String name;
    private String phone_num;
    private String user_birth;  // ������� �ʵ�

   
}
