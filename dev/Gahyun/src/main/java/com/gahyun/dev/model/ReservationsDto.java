package com.gahyun.dev.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

public class ReservationsDto {
	private int reservation_id;;
	private int user_id;
	private int room_id;
	private Date check_in_date;
	private Date check_out_date;
	private BigDecimal total_price;
	private String status;
	private Timestamp created_at;
	
	public ReservationsDto(int reservation_id, int user_id, int room_id, Date check_in_date, Date check_out_date,
			BigDecimal total_price, String status, Timestamp created_at) {
	
		this.reservation_id = reservation_id;
		this.user_id = user_id;
		this.room_id = room_id;
		this.check_in_date = check_in_date;
		this.check_out_date = check_out_date;
		this.total_price = total_price;
		this.status = status;
		this.created_at = created_at;
	}

	public int getReservation_id() {
		return reservation_id;
	}

	public void setReservation_id(int reservation_id) {
		this.reservation_id = reservation_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getRoom_id() {
		return room_id;
	}

	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}

	public Date getCheck_in_date() {
		return check_in_date;
	}

	public void setCheck_in_date(Date check_in_date) {
		this.check_in_date = check_in_date;
	}

	public Date getCheck_out_date() {
		return check_out_date;
	}

	public void setCheck_out_date(Date check_out_date) {
		this.check_out_date = check_out_date;
	}

	public BigDecimal getTotal_price() {
		return total_price;
	}

	public void setTotal_price(BigDecimal total_price) {
		this.total_price = total_price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}
	
	
	
}
