package com.gahyun.dev.model;

import java.math.BigDecimal;
import java.sql.Date;

import lombok.Data;

@Data
public class PromotionsDto {
	private int promo_id;
	private String promo_code;
	private BigDecimal dis_per;
	private Date start_date;
	private Date end_date;
	
}
