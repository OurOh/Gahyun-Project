package com.gahyun.dev.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gahyun.dev.model.ReservationDTO;

@Mapper
	public interface ReservationMapper {

	    // 현재 예약 조회
	    List<ReservationDTO> findCurrentReservations();

	    // 과거 예약 조회
	    List<ReservationDTO> findPastReservations();
	}


