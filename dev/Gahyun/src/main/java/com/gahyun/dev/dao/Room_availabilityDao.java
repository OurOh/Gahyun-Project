package com.gahyun.dev.dao;

import java.util.List;

import com.gahyun.dev.model.Room_availabilityDto;



public interface Room_availabilityDao {
  List<Room_availabilityDto> getAllAvail();
  Room_availabilityDto getAvail(int id);
  void insertAvail(Room_availabilityDto dto);
  void updateAvail(Room_availabilityDto dto);
  void delAvail(int id);
}
