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
        String sql = "SELECT * FROM user WHERE userid = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{userid}, userRowMapper);
    }
    public UserDto getUserByUserPid(String user_id) {
    	String sql = "SELECT * FROM user WHERE user_id = ?";
    	return jdbcTemplate.queryForObject(sql, new Object[] {user_id}, userRowMapper);
    }
    
    public String getPidByUserid(String userid) {
    	String sql = "SELECT user_id FROM user WHERE userid = ?";
    	return jdbcTemplate.queryForObject(sql, new Object[]{userid}, String.class);
    }


    //데이터베이스의 각 행(row)을 UserDto 객체로 변환하여 반환하는 역할
    private RowMapper<UserDto> userRowMapper = (rs, rowNum) -> {
        UserDto user = new UserDto();
        user.setUserid(rs.getString("userid"));
        user.setPassword(rs.getString("password"));
        user.setName(rs.getString("name"));
        user.setPhone_num(rs.getString("phone_num"));
        user.setUser_birth(rs.getString("user_birth"));
        user.setEmail(rs.getString("email")); // 이메일 필드 추가
        return user;
    };

    
    //정보수정
    public void updateUser(UserDto user) {
        String sql = "UPDATE user SET name = ?, password = ?, email = ?, phone_num = ?, user_birth = ? WHERE userid = ?";
        jdbcTemplate.update(sql, 
            user.getName(),
            user.getPassword(),
            user.getEmail(),
            user.getPhone_num(),
            user.getUser_birth(),
            user.getUserid());
    }


    
    // 새로운 사용자 등록
    @Override
    public void insertUser(UserDto user) {
        String sql = "INSERT INTO user (userid, password, name, phone_num, user_birth, email) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, 
            user.getUserid(), 
            user.getPassword(), 
            user.getName(), 
            user.getPhone_num(), 
            user.getUser_birth(), 
            user.getEmail()); // 이메일 추가
    }
    
    
}