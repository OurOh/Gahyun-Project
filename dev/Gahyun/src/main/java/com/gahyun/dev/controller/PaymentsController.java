package com.gahyun.dev.controller;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gahyun.dev.service.PaymentService;

@Controller
@RequestMapping("/payment")
public class PaymentsController {

    @Autowired
    private PaymentService paymentService;


    @PostMapping("/complete")  // /payment/complete 寃쎈줈 �꽕�젙
    @ResponseBody
    public Map<String, Object> paymentComplete(@RequestBody Map<String, Object> paymentData) {
        Map<String, Object> response = new HashMap<>();
        try {
            // 1. �슂泥� �뜲�씠�꽣 �닔�떊 諛� 蹂��솚
            System.out.println("1. 결제 데이터 수신: " + paymentData);

            int userId = ((Number) paymentData.get("userId")).intValue();
            int roomId = ((Number) paymentData.get("roomId")).intValue();
            BigDecimal paidAmount = new BigDecimal(paymentData.get("paid_amount").toString());  // BigDecimal濡� 蹂��솚

            String checkInDateStr = (String) paymentData.get("checkInDate");
            String checkOutDateStr = (String) paymentData.get("checkOutDate");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date checkInDate = new Date(dateFormat.parse(checkInDateStr).getTime());
            Date checkOutDate = new Date(dateFormat.parse(checkOutDateStr).getTime());
              
            System.out.println("2. 예약데이터 변환 완료");

            System.out.println(userId+"||"+roomId+"||"+paidAmount+"||"+checkInDate+"||"+checkOutDate+"||");
            
            // 2. �삁�빟 �젙蹂� ���옣
            boolean reservationSuccess = paymentService.saveReservation(userId, roomId, checkInDate, checkOutDate, paidAmount);
            System.out.println("3. 예약 저장 성공 여부: " + reservationSuccess);

            if (reservationSuccess) {
                int reservationId = paymentService.getLatestReservationId(userId, roomId);
                System.out.println("4. 최신 예약 ID: " + reservationId);

                // 3. 寃곗젣 �젙蹂� ���옣
                boolean paymentSuccess = paymentService.savePayment(reservationId, "CARD", paidAmount);
                System.out.println("5. 결제 저장 성공 여부: " + paymentSuccess);

                response.put("result", paymentSuccess ? "success" : "failure");
                response.put("message", paymentSuccess ? "결제가 완료되었습니다." : "결제 정보 저장 실패");
                System.out.println("결제 정보 저장에 실패했습니당."); // 濡쒓렇 異붽�
            } else {
                response.put("result", "failure");
                response.put("message", "예약 정보 저장 실패");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.put("result", "failure");
            response.put("message", "�삁�쇅 諛쒖깮: " + e.getMessage());
        }
        return response;
    }
}