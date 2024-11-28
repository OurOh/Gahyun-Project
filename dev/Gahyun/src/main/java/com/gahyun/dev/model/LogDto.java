package com.gahyun.dev.model;

import java.sql.Timestamp;

import lombok.Data;


@Data
public class LogDto {
	private int log_id;
	private int user_id;
	private String action;
	private Timestamp created_at;
	
}
