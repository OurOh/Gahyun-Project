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

    // 결제 페이지로 이동
    @GetMapping("/page")
    public String paymentPage(Model model) {
        return "payment";  // 결제 페이지 (payment.jsp로 이동)
    }

    @PostMapping("/complete")  // /payment/complete 경로 설정
    @ResponseBody
    public Map<String, Object> paymentComplete(@RequestBody Map<String, Object> paymentData) {
        Map<String, Object> response = new HashMap<>();
        try {
            // 1. 요청 데이터 수신 및 변환
            System.out.println("1. 결제 데이터 수신: " + paymentData);

            int userId = ((Number) paymentData.get("userId")).intValue();
            int roomId = ((Number) paymentData.get("roomId")).intValue();
            BigDecimal paidAmount = new BigDecimal(paymentData.get("paid_amount").toString());  // BigDecimal로 변환

            String checkInDateStr = (String) paymentData.get("checkInDate");
            String checkOutDateStr = (String) paymentData.get("checkOutDate");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date checkInDate = new Date(dateFormat.parse(checkInDateStr).getTime());
            Date checkOutDate = new Date(dateFormat.parse(checkOutDateStr).getTime());

            System.out.println("2. 예약 데이터 변환 완료");

            // 2. 예약 정보 저장
            boolean reservationSuccess = paymentService.saveReservation(userId, roomId, checkInDate, checkOutDate, paidAmount);
            System.out.println("3. 예약 저장 성공 여부: " + reservationSuccess);

            if (reservationSuccess) {
                int reservationId = paymentService.getLatestReservationId(userId, roomId);
                System.out.println("4. 최신 예약 ID: " + reservationId);

                // 3. 결제 정보 저장
                boolean paymentSuccess = paymentService.savePayment(reservationId, "CARD", paidAmount);
                System.out.println("5. 결제 저장 성공 여부: " + paymentSuccess);

                response.put("result", paymentSuccess ? "success" : "failure");
                response.put("message", paymentSuccess ? "결제가 완료되었습니다." : "결제 정보 저장 실패");
                System.out.println("결제 정보 저장에 실패했습니다."); // 로그 추가
            } else {
                response.put("result", "failure");
                response.put("message", "예약 정보 저장 실패");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.put("result", "failure");
            response.put("message", "예외 발생: " + e.getMessage());
        }
        return response;
    }
}