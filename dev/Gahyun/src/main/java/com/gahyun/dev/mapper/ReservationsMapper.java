package com.gahyun.dev.mapper;



import com.gahyun.dev.model.UserDto;

// Mapper �������̽��� ������ ������ ������ �����ͺ��̽��� �����ϰų� ��ȸ�ϴ� ���
public interface ReservationsMapper {
	   UserDto getMemberUserId(String userid); //���̵� ��������
	   void setInsertUser(UserDto userDto); //ȸ������ 

}