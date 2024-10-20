package com.gahyun.dev.model;

import java.sql.Timestamp;
import java.time.LocalDate;

import lombok.Data;

@Data
public class UserDto {

    private int user_id;        // ����� ���� ID
    private String name;        // ����� �̸�
    private String email;       // �̸���
    private String password;    // ��й�ȣ
    private String phone_num;   // ��ȭ��ȣ
    private Timestamp created_at; // ���� �ð�
    private LocalDate user_birth; // �������
    private String userid;      // �α��� �� ���Ǵ� ���̵�
    
}
