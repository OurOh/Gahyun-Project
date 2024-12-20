package com.gahyun.dev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
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

    @Autowired
    private JavaMailSender mailSender;

    // 사용자 인증 정보 로드
    @Override
    public UserDetails loadUserByUsername(String userid) throws UsernameNotFoundException {
        UserDto user = userDao.getUserByUserId(userid);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with userid: " + userid);
        }
        return new CustomUserDetails(user);
    }

    // 사용자 인증 (로그인 시 사용)
    @Override
    public UserDto authenticate(String userid, String password) {
        UserDto user = userDao.getUserByUserId(userid);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return user;
        } else {
            return null;
        }
    }

    // 회원가입 처리
    @Override
    public void insertUser(UserDto newUser) {
        String encodedPassword = passwordEncoder.encode(newUser.getPassword());
        newUser.setPassword(encodedPassword);
        userDao.insertUser(newUser);
    }

 // 아이디 중복 체크
    @Override
    public boolean isUserIdAvailable(String userid) {
        return !userDao.isUserIdExists(userid); // isUserIdExists 호출하여 아이디가 없을 때 true 반환
    }

    // 사용자 정보 업데이트 처리
    @Override
    public void updateUser(UserDto user) {
        if (!user.getPassword().startsWith("$2a$")) {
            String encodedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encodedPassword);
        }
        userDao.updateUser(user);
    }

    // 아이디 찾기
    @Override
    public String findUserIdByNameAndEmail(String name, String email) {
        return userDao.findUserIdByNameAndEmail(name, email);
    }

    // 비밀번호 초기화
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

    // 임시 비밀번호 이메일 전송 메서드
    private void sendTemporaryPasswordEmail(String email, String tempPassword) {
        System.out.println("Sending temporary password to: " + email);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("임시 비밀번호 안내");
        message.setText("안녕하세요,\n\n요청하신 임시 비밀번호는 다음과 같습니다: " + tempPassword + "\n\n로그인 후 비밀번호를 변경해주세요.\n감사합니다.");

        try {
            mailSender.send(message);
            System.out.println("Temporary password email sent successfully!");
        } catch (Exception e) {
            System.out.println("Failed to send temporary password email.");
            e.printStackTrace();
        }
    }
}
