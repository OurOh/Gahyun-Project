package com.gahyun.dev.model;

import java.math.BigDecimal;
import java.sql.Date;

public class PromotionsDto {
	private int promo_id;
	private String promo_code;
	private BigDecimal dis_per;
	private Date start_date;
	private Date end_date;
	
	public PromotionsDto(int promo_id, String promo_code, BigDecimal dis_per, Date start_date, Date end_date) {
		
		this.promo_id = promo_id;
		this.promo_code = promo_code;
		this.dis_per = dis_per;
		this.start_date = start_date;
		this.end_date = end_date;
	}

	public int getPromo_id() {
		return promo_id;
	}

	public void setPromo_id(int promo_id) {
		this.promo_id = promo_id;
	}

	public String getPromo_code() {
		return promo_code;
	}

	public void setPromo_code(String promo_code) {
		this.promo_code = promo_code;
	}

	public BigDecimal getDis_per() {
		return dis_per;
	}

	public void setDis_per(BigDecimal dis_per) {
		this.dis_per = dis_per;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	
}
