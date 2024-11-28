package com.gahyun.dev.dao;

import java.util.List;

import com.gahyun.dev.model.RoomsDto;



public interface RoomsDao {
  List<RoomsDto> getAllRooms();
  RoomsDto getRooms(int id);
  void insertRooms(RoomsDto dto);
  void updateRooms(RoomsDto dto);
  void delRooms(int id);
}
