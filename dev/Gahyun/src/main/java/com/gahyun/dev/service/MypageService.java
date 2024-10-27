package com.gahyun.dev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gahyun.dev.mapper.MypageMapper;
import com.gahyun.dev.model.MypageDto;



@Service
public class MypageService {

    @Autowired
    private MypageMapper mypageMapper;

    public List<MypageDto> getCurrentMypage(String userId) {
        return mypageMapper.findCurrentMypage();
    }

    public List<MypageDto> getPastMypage(String userId) {
        return mypageMapper.findPastMypage();
    }
}
