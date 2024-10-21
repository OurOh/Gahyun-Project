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
        return user;
    };
}
