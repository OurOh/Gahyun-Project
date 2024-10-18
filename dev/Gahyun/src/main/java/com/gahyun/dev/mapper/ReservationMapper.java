package com.gahyun.dev.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gahyun.dev.model.ReservationDTO;

@Mapper
	public interface ReservationMapper {

	    // ���� ���� ��ȸ
	    List<ReservationDTO> findCurrentReservations();

	    // ���� ���� ��ȸ
	    List<ReservationDTO> findPastReservations();
	}


