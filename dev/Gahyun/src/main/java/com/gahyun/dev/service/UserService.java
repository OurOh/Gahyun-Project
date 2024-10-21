package com.gahyun.dev.service;

import com.gahyun.dev.model.UserDto;

public interface UserService {
    UserDto authenticate(String userid, String password);
    
}