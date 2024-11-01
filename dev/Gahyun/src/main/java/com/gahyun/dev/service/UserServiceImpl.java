package com.gahyun.dev.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gahyun.dev.dao.UserDao;
import com.gahyun.dev.model.CustomUserDetails;
import com.gahyun.dev.model.UserDto;


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
        System.out.println("User found: " + user);
        System.out.println("User ID: " + user.getUserid());
        System.out.println("User Password: " + user.getPassword());
        
      
        
        return new CustomUserDetails(user);
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
    
    
    // 이름과 이메일을 이용하여 아이디 찾기
    @Override
    public String findUserIdByNameAndEmail(String name, String email) {
        return userDao.findUserIdByNameAndEmail(name, email);
    }
    
    //비밀번호 초기화.
    @Override
    public void resetPassword(String userid, String encodedPassword, String tempPassword) {
        UserDto user = userDao.getUserByUserId(userid);
        if (user != null) {
            user.setPassword(encodedPassword);
            userDao.updateUser(user);
            sendTemporaryPasswordEmail(user.getEmail(), tempPassword);
        }
    }

    @Override
    public boolean isUserValidForPasswordReset(String userid, String name, String email) {
        UserDto user = userDao.getUserByUserId(userid);
        return user != null && user.getName().equals(name) && user.getEmail().equals(email);
    }

    private void sendTemporaryPasswordEmail(String email, String tempPassword) {
        // 여기에 이메일 전송 로직 추가
        System.out.println("Sending temporary password to: " + email);
        System.out.println("Temporary password: " + tempPassword);
        // 실제 이메일 전송 코드 구현 필요
    }
}
