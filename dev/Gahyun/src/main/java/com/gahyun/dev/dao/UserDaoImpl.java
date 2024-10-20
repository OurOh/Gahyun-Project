package com.gahyun.dev.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.gahyun.dev.model.UserDto;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SqlSession sqlSession;

    private static final String NAMESPACE = "com.gahyun.dev.mapper.UserMapper";

    @Override
    public List<UserDto> getAllUser() {
        return sqlSession.selectList(NAMESPACE + ".getAllUser");
    }

    @Override
    public UserDto getUser(int id) {
        return sqlSession.selectOne(NAMESPACE + ".getUser", id);
    }

    @Override
    public UserDto getUserByUserid(String userid) {
        return sqlSession.selectOne(NAMESPACE + ".getUserByUserid", userid);
    }

    @Override
    public void insertUser(UserDto dto) {
        sqlSession.insert(NAMESPACE + ".insertUser", dto);
    }

    @Override
    public void updateUser(UserDto dto) {
        sqlSession.update(NAMESPACE + ".updateUser", dto);
    }

    @Override
    public void delUser(int id) {
        sqlSession.delete(NAMESPACE + ".delUser", id);
    }
}
