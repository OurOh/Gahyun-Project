package com.gahyun.dev.dao;

import java.util.List;

import com.gahyun.dev.model.MypageDto;



public interface MypageDao {
  List<MypageDto> getAllRes();
  MypageDto getRes(int id);
  void insertRes(MypageDto dto);
  void updateRes(MypageDto dto);
  void delRes(int id);
}