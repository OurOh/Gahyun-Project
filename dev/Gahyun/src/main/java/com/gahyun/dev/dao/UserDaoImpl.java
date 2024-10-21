package com.gahyun.dev.dao;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.gahyun.dev.model.UserDto;

@Repository
public class UserDaoImpl implements UserDao {

    private final JdbcTemplate jdbcTemplate;

    public UserDaoImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public UserDto getUserByUserId(String userid) {
        String sql = "SELECT * FROM users WHERE userid = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{userid}, userRowMapper);
    }

    private RowMapper<UserDto> userRowMapper = (rs, rowNum) -> {
        UserDto user = new UserDto();
        user.setUserid(rs.getString("userid"));
        user.setPassword(rs.getString("password"));
        user.setName(rs.getString("name"));
        user.setEmail(rs.getString("email"));
        user.setPhone_num(rs.getString("phone_num"));
        user.setUser_birth(rs.getString("user_birth"));
        return user;
    };

    
    //정보수정
    @Override
    public void updateUser(UserDto user) {
        String sql = "UPDATE users SET password = ?, name = ?, phone_num = ?, user_birth = ? WHERE userid = ?";
        jdbcTemplate.update(sql, 
        		user.getPassword(), 
        		user.getName(), 
        		user.getPhone_num(), 
        		user.getUser_birth(), 
        		user.getUserid());
    }

    
     //새로운 사용자 등록
     @Override
     public void insertUser(UserDto user) {
    	 String sql = "INSERT INTO users (userid, password, name, phone_num, user_birth) VALUES (?, ?, ?, ?, ?)";
    	 jdbcTemplate.update(sql, 
    			 user.getUserid(), 
    			 user.getPassword(), 
    			 user.getName(), 
    			 user.getPhone_num(), 
    			 user.getUser_birth());
    }
    
    
}