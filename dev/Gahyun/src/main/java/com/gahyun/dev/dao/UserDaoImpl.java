package com.gahyun.dev.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gahyun.dev.mapper.MemberMapper;
import com.gahyun.dev.model.UserDto;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private MemberMapper mem;
	
	
	@Override
	public List<UserDto> getAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto getUser(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertUser(UserDto dto) {
	    System.out.println("Inserting User in DAO: " + dto);
	    try {
	        mem.setInsertUser(dto);  // 실제 쿼리 실행
	        System.out.println("Insert finished in DAO");
	    } catch (Exception e) {
	        System.out.println("Exception during insert in DAO: " + e.getMessage());
	        e.printStackTrace();  // 예외 발생 시 출력
	    }
	}

	@Override
	public void updateUser(UserDto dto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delUser(int id) {
		// TODO Auto-generated method stub

	}

}
