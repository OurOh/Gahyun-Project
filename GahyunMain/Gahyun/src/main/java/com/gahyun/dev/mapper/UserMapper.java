package com.gahyun.dev.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.gahyun.dev.model.UserDto;

@Mapper
public interface UserMapper {
	
    @Select("SELECT * FROM user WHERE user_id = #{userId}")
    UserDto getUserById(int userId);
}
