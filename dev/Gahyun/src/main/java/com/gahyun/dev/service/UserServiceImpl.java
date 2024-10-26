package com.gahyun.dev.service;

import com.gahyun.dev.dao.UserDao;
import com.gahyun.dev.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Spring Security가 요구하는 메서드: 사용자의 인증 정보 로드
    @Override
    public UserDetails loadUserByUsername(String userid) throws UsernameNotFoundException {
        UserDto user = userDao.getUserByUserId(userid);

        if (user == null) {
            throw new UsernameNotFoundException("User not found with userid: " + userid);
        }

        return User.withUsername(user.getUserid())
                   .password(user.getPassword())  // 이미 암호화된 비밀번호
                   .authorities("ROLE_USER")      // 권한 부여
                   .build();
    }

    // 사용자 인증 (로그인 시 사용)
    @Override
    public UserDto authenticate(String userid, String password) {
        UserDto user = userDao.getUserByUserId(userid);

        // 비밀번호 비교 (Spring Security에서 제공하는 passwordEncoder 사용)
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return user;
        } else {
            return null;  // 인증 실패
        }
    }

    // 회원가입 처리 (비밀번호 암호화 포함)
    @Override
    public void insertUser(UserDto newUser) {
        // 비밀번호를 BCrypt로 암호화
        String encodedPassword = passwordEncoder.encode(newUser.getPassword());
        newUser.setPassword(encodedPassword);

        // DB에 사용자 정보 저장
        userDao.insertUser(newUser);
    }

    // 사용자 정보 업데이트 처리
    @Override
    public void updateUser(UserDto user) {
        // 비밀번호가 이미 암호화되어 있지 않다면 암호화
        if (!user.getPassword().startsWith("$2a$")) {  // BCrypt 암호화된 비밀번호는 $2a$로 시작
            String encodedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encodedPassword);
        }

        // DB 업데이트
        userDao.updateUser(user);
    }
}
