package com.gahyun.dev.service;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    private IamportClient iamportClient;

    @Autowired
    private ReservationsMapper reservationsMapper;

    @Autowired
    private PaymentMapper paymentMapper;

    @Autowired
    private UserMapper userMapper;

    public PaymentService() {
        this.iamportClient = new IamportClient("0568173124846817", "02CBy0mr1VegHbFWBOm6yiFGbaaqET3ZV98Hdlg4XBkxqsblhwuE1LQYlyEQlAbcp9njZuUKa3VTeAQK");
    }

    public AccessToken getAccessToken() {
        try {
            return iamportClient.getAuth().getResponse();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    // 寃곗젣 �꽭遺� �젙蹂� 硫붿꽌�뱶
    public Map<String, Object> getPaymentDetails(int userId) {
        Map<String, Object> paymentDetails = new HashMap<>();
        UserDto user = userMapper.getUserById(userId);

        if (user != null) {
            paymentDetails.put("buyerName", user.getName());
            paymentDetails.put("buyerEmail", user.getEmail());
            paymentDetails.put("buyerTel", user.getPhone_num());

            ReservationsDto reservation = reservationsMapper.getReservationByUserId(userId);
            paymentDetails.put("amount", reservation != null ? reservation.getTotal_price() : 100); // 怨좎젙 湲덉븸 �삁�떆
        }

        return paymentDetails;
    }

    // �삁�빟 ���옣 硫붿꽌�뱶
    public boolean saveReservation(int userId, int roomId, Date checkInDate, Date checkOutDate, BigDecimal totalPrice) {
        ReservationsDto reservation = new ReservationsDto();
        reservation.setUser_id(userId);
        reservation.setRoom_id(roomId);
        reservation.setCheck_in_date(checkInDate);
        reservation.setCheck_out_date(checkOutDate);
        reservation.setTotal_price(totalPrice);  // BigDecimal �궗�슜
        reservation.setStatus("BOOKED");

        try {
            reservationsMapper.insertReservation(reservation);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

 // 寃곗젣 ���옣 硫붿꽌�뱶
    public boolean savePayment(int reservationId, String paymentMethod, BigDecimal amount) {
        PaymentsDto payment = new PaymentsDto();
        payment.setReservation_id(reservationId);
        payment.setPayment_method(paymentMethod);
        payment.setPayment_amount(amount);  // BigDecimal �궗�슜
        payment.setPayment_status("PAID");

        try {
            paymentMapper.insertPayment(payment);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getLatestReservationId(int userId, int roomId) {
    	return paymentMapper.getLatestReservationId(userId, roomId);
    }
}