package com.gahyun.dev.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
public class UserDto {
    
	
    private String userid;
    private String password;
    private String name;
    private String phone_num;
    private String user_birth;  
    private String email;
   
}
