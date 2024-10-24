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

    // Spring Security�� �䱸�ϴ� �޼���: ������� ���� ���� �ε�
    @Override
    public UserDetails loadUserByUsername(String userid) throws UsernameNotFoundException {
        UserDto user = userDao.getUserByUserId(userid);

        if (user == null) {
            throw new UsernameNotFoundException("User not found with userid: " + userid);
        }

        return User.withUsername(user.getUserid())
                   .password(user.getPassword())  // �̹� ��ȣȭ�� ��й�ȣ
                   .authorities("ROLE_USER")      // ���� �ο�
                   .build();
    }

    // ����� ���� (�α��� �� ���)
    @Override
    public UserDto authenticate(String userid, String password) {
        UserDto user = userDao.getUserByUserId(userid);

        // ��й�ȣ �� (Spring Security���� �����ϴ� passwordEncoder ���)
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return user;
        } else {
            return null;  // ���� ����
        }
    }

    // ȸ������ ó�� (��й�ȣ ��ȣȭ ����)
    @Override
    public void insertUser(UserDto newUser) {
        // ��й�ȣ�� BCrypt�� ��ȣȭ
        String encodedPassword = passwordEncoder.encode(newUser.getPassword());
        newUser.setPassword(encodedPassword);

        // DB�� ����� ���� ����
        userDao.insertUser(newUser);
    }

    // ����� ���� ������Ʈ ó��
    @Override
    public void updateUser(UserDto user) {
        // ��й�ȣ�� �̹� ��ȣȭ�Ǿ� ���� �ʴٸ� ��ȣȭ
        if (!user.getPassword().startsWith("$2a$")) {  // BCrypt ��ȣȭ�� ��й�ȣ�� $2a$�� ����
            String encodedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encodedPassword);
        }

        // DB ������Ʈ
        userDao.updateUser(user);
    }
}
