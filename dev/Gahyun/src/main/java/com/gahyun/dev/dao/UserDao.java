package com.gahyun.dev.dao;



import com.gahyun.dev.model.UserDto;



public interface UserDao {
    UserDto getUserByUserId(String userid);
    
   
}
