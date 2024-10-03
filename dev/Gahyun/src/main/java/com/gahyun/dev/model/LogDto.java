package com.gahyun.dev.model;

import java.sql.Timestamp;

public class LogDto {
	private int log_id;
	private int user_id;
	private String action;
	private Timestamp created_at;
	
	public LogDto(int log_id, int user_id, String action, Timestamp created_at) {
	
		this.log_id = log_id;
		this.user_id = user_id;
		this.action = action;
		this.created_at = created_at;
	}
	//getter setter
	public int getLog_id() {
		return log_id;
	}
	public void setLog_id(int log_id) {
		this.log_id = log_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public Timestamp getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}
}
