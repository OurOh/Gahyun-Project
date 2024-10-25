package com.gahyun.dev.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.gahyun.dev.model.UserDto;

@Mapper
public interface UserMapper {
	// 유저 ID로 유저 정보를 가져오는 쿼리
    @Select("SELECT * FROM user WHERE user_id = #{userId}")
    UserDto getUserById(int userId);
}
