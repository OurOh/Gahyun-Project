package com.gahyun.dev.dao;

import java.util.List;

import com.gahyun.dev.model.ReservationsDto;



public interface ReservationsDao {
  List<ReservationsDto> getAllUser();
  ReservationsDto getUser(int id);
  void insertUser(ReservationsDto dto);
  void updateUser(ReservationsDto dto);
  void delUser(int id);
}
