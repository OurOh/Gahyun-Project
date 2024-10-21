package com.gahyun.dev.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDto {
	
    private String userid;
    private String password;
    private String name;
    private String email;
    private String phone_num;
    private String user_birth;  // ������� �ʵ� �߰�

    // ������� Setter
    public void setUser_birth(String user_birth) {
        this.user_birth = user_birth;
    }

    // ������� Getter
    public String getUser_birth() {
        return user_birth;
    }
}
