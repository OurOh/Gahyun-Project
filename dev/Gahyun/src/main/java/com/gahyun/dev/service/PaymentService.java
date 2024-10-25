package com.gahyun.dev.service;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gahyun.dev.mapper.ReservationsMapper;
import com.gahyun.dev.mapper.UserMapper;
import com.gahyun.dev.model.ReservationsDto;
import com.gahyun.dev.model.UserDto;
import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.response.AccessToken;

@Service
public class PaymentService {

    private IamportClient iamportClient;

    @Autowired
    private ReservationsMapper reservationsMapper;

    @Autowired
    private UserMapper userMapper;

    public PaymentService() {
        // 아임포트 클라이언트 초기화
        this.iamportClient = new IamportClient("0568173124846817", "02CBy0mr1VegHbFWBOm6yiFGbaaqET3ZV98Hdlg4XBkxqsblhwuE1LQYlyEQlAbcp9njZuUKa3VTeAQK");
    }

    // 아임포트 토큰을 얻는 메서드
    public AccessToken getAccessToken() {
        try {
            return iamportClient.getAuth().getResponse();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // 유저 ID로 예약 정보를 가져오는 메서드
    public ReservationsDto getReservationByUserId(int userId) {
        return reservationsMapper.getReservationByUserId(userId);
    }

    // 결제 정보를 유저 ID에 따라 가져오는 메서드
    public Map<String, Object> getPaymentDetails(int userId) {
        Map<String, Object> paymentDetails = new HashMap<>();

        // 유저 정보 가져오기
        UserDto user = userMapper.getUserById(userId);
        if (user != null) {
            // 유저 정보를 세팅
            paymentDetails.put("buyerName", user.getName());
            paymentDetails.put("buyerEmail", user.getEmail());
            paymentDetails.put("buyerTel", user.getPhone_num());

            // 예약 정보에서 총 금액을 계산
            ReservationsDto reservation = reservationsMapper.getReservationByUserId(userId);
            if (reservation != null) {
                paymentDetails.put("amount", reservation.getTotal_price());
            } else {
                // 만약 예약 정보가 없으면 기본 금액 설정 (임시)
                paymentDetails.put("amount", 0);
            }
        }

        return paymentDetails;
    }
    // 결제 후 예약 정보를 저장하는 메서드
    public boolean saveReservation(int userId, int roomId, Date checkInDate, Date checkOutDate, double totalPrice) {
        ReservationsDto reservation = new ReservationsDto();
        reservation.setUser_id(userId);
        reservation.setRoom_id(roomId);
        reservation.setCheck_in_date(checkInDate);
        reservation.setCheck_out_date(checkOutDate);
        reservation.setTotal_price(totalPrice);
        reservation.setStatus("PAID");

        try {
            reservationsMapper.insertReservation(reservation);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
