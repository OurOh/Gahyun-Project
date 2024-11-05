package com.gahyun.dev.service;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.gahyun.dev.mapper.PaymentMapper;
import com.gahyun.dev.mapper.ReservationsMapper;
import com.gahyun.dev.mapper.UserMapper;
import com.gahyun.dev.model.PaymentsDto;
import com.gahyun.dev.model.ReservationsDto;
import com.gahyun.dev.model.UserDto;
import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.response.AccessToken;

@Service
public class PaymentService {

	private final String API_KEY = "0568173124846817";  
    private final String API_SECRET = "02CBy0mr1VegHbFWBOm6yiFGbaaqET3ZV98Hdlg4XBkxqsblhwuE1LQYlyEQlAbcp9njZuUKa3VTeAQK"; 

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ReservationsMapper reservationsMapper;

    @Autowired
    private PaymentMapper paymentMapper;
    
    // Access Token 발급 메서드
    public String getAccessToken() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.iamport.kr/users/getToken";

        // 요청 바디에 API Key와 Secret 추가
        Map<String, String> body = new HashMap<>();
        body.put("imp_key", API_KEY);
        body.put("imp_secret", API_SECRET);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        HttpEntity<Map<String, String>> entity = new HttpEntity<>(body, headers);

        // Access Token 요청
        ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.POST, entity, Map.class);
        Map<String, Object> responseBody = response.getBody();

        if (responseBody != null && (Integer) responseBody.get("code") == 0) {
            Map<String, String> responseData = (Map<String, String>) responseBody.get("response");
            return responseData.get("access_token");
        }

        return null;
    }
 // 결제 정보 조회 메서드
    public Map<String, Object> getPaymentDetails(int userId) {
        Map<String, Object> paymentDetails = new HashMap<>();
        UserDto user = userMapper.getUserById(userId);

        if (user != null) {
            paymentDetails.put("buyerName", user.getName());
            paymentDetails.put("buyerEmail", user.getEmail());
            paymentDetails.put("buyerTel", user.getPhone_num());

            ReservationsDto reservation = reservationsMapper.getReservationByUserId(userId);
            paymentDetails.put("amount", reservation != null ? reservation.getTotal_price() : 100); // 
        }

        return paymentDetails;
    }

 // 예약 저장 메서드
    public boolean saveReservation(int userId, int roomId, Date checkInDate, Date checkOutDate, BigDecimal totalPrice) {
        ReservationsDto reservation = new ReservationsDto();
        reservation.setUser_id(userId);
        reservation.setRoom_id(roomId);
        reservation.setCheck_in_date(checkInDate);
        reservation.setCheck_out_date(checkOutDate);
        reservation.setTotal_price(totalPrice);  
        reservation.setStatus("BOOKED");

        try {
            reservationsMapper.insertReservation(reservation);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // 결제 저장 메서드
    public boolean savePayment(int reservationId, String paymentMethod, BigDecimal amount, String paymentKey) {
        PaymentsDto payment = new PaymentsDto();
        payment.setReservation_id(reservationId);
        payment.setPayment_method(paymentMethod);
        payment.setPayment_amount(amount);
        payment.setPaymentKey(paymentKey); // 결제 키 설정
        payment.setPayment_status("PAID");

        try {
            paymentMapper.insertPayment(payment);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
 // 가장 최근 예약 ID 조회 메서드
    public int getLatestReservationId(int userId, int roomId) {
        return paymentMapper.getLatestReservationId(userId, roomId);
    }

    // 결제 키 조회 메서드
    public String getPaymentKeyFromReservation(String reservationId) {
        return paymentMapper.getPaymentKeyFromReservation(reservationId);
    }

 // 결제 취소 메서드
    public boolean cancelPayment(String impUid) {
        String accessToken = getAccessToken();
        if (accessToken == null) {
            System.out.println("Access Token 발급 실패");
            return false;
        }

        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.iamport.kr/payments/cancel";

        Map<String, Object> body = new HashMap<>();
        body.put("imp_uid", impUid);
        body.put("reason", "고객 요청으로 인한 취소");

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        headers.set("Authorization", accessToken);
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(body, headers);

        try {
            ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.POST, entity, Map.class);
            Map<String, Object> responseBody = response.getBody();

            if (responseBody != null && (Integer) responseBody.get("code") == 0) {
                System.out.println("결제 취소 성공");
                return true;
            } else {
                System.out.println("결제 취소 실패: " + responseBody.get("message"));
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // 예약 상태 업데이트 메서드
    public void updateReservationStatus(String reservationId, String status) {
        Map<String, Object> params = new HashMap<>();
        params.put("reservationId", reservationId);
        params.put("status", status);
        paymentMapper.updateReservationStatus(params);
    }
    
    public void updatePaymentStatus(String impUid, String status) {
        paymentMapper.updatePaymentStatus(impUid, status);
    }
}