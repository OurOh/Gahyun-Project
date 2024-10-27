package com.gahyun.dev.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gahyun.dev.model.MypageDto;

@Mapper
public interface MypageMapper {
    List<MypageDto> findCurrentMypage();
    List<MypageDto> findPastMypage();
}