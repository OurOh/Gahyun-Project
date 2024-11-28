package com.gahyun.dev.model;

import java.sql.Timestamp;
import java.time.LocalDate;

import lombok.Data;

@Data
public class UserDto {
	
	private int user_id;
	private String name;
	private String email;
	private String password;
	private String phone_num;
	private Timestamp created_at;
	private LocalDate user_birth;
	private String userid;
	
}
