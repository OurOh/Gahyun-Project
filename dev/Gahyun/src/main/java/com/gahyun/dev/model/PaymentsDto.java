package com.gahyun.dev.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class PaymentsDto {
	private int pament_id;
	private int reservation_id;
	private String payment_method;
	private BigDecimal payment_amount;
	private Timestamp payment_date;
	private String payment_status;
	
	public PaymentsDto(int pament_id, int reservation_id, String payment_method, BigDecimal payment_amount,
			Timestamp payment_date, String payment_status) {

		this.pament_id = pament_id;
		this.reservation_id = reservation_id;
		this.payment_method = payment_method;
		this.payment_amount = payment_amount;
		this.payment_date = payment_date;
		this.payment_status = payment_status;
	}

	public int getPament_id() {
		return pament_id;
	}

	public void setPament_id(int pament_id) {
		this.pament_id = pament_id;
	}

	public int getReservation_id() {
		return reservation_id;
	}

	public void setReservation_id(int reservation_id) {
		this.reservation_id = reservation_id;
	}

	public String getPayment_method() {
		return payment_method;
	}

	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}

	public BigDecimal getPayment_amount() {
		return payment_amount;
	}

	public void setPayment_amount(BigDecimal payment_amount) {
		this.payment_amount = payment_amount;
	}

	public Timestamp getPayment_date() {
		return payment_date;
	}

	public void setPayment_date(Timestamp payment_date) {
		this.payment_date = payment_date;
	}

	public String getPayment_status() {
		return payment_status;
	}

	public void setPayment_status(String payment_status) {
		this.payment_status = payment_status;
	}
	
	
}
