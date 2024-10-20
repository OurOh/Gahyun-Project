package com.gahyun.dev.dao;

import java.util.List;

import com.gahyun.dev.model.ReservationsDto;



public interface ReservationsDao {
  List<ReservationsDto> getAllRes();
  ReservationsDto getRes(int id);
  void insertRes(ReservationsDto dto);
  void updateRes(ReservationsDto dto);
  void delRes(int id);
}
