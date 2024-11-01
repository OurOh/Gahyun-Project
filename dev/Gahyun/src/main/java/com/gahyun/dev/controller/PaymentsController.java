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
public class PaymentsController {

    @Autowired
    private PaymentService paymentService;


    @PostMapping("/complete")  
    @ResponseBody
    public Map<String, Object> paymentComplete(@RequestBody Map<String, Object> paymentData) {
        Map<String, Object> response = new HashMap<>();
        try {
        	// 결제 데이터 수신 및 변환
            System.out.println("1. 결제 데이터 수신: " + paymentData);

            int userId = ((Number) paymentData.get("userId")).intValue();
            int roomId = ((Number) paymentData.get("roomId")).intValue();
            BigDecimal paidAmount = new BigDecimal(paymentData.get("paid_amount").toString()); 

            String checkInDateStr = (String) paymentData.get("checkInDate");
            String checkOutDateStr = (String) paymentData.get("checkOutDate");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date checkInDate = new Date(dateFormat.parse(checkInDateStr).getTime());
            Date checkOutDate = new Date(dateFormat.parse(checkOutDateStr).getTime());
              
            System.out.println("2. 예약데이터 변환 완료");

            System.out.println(userId+"||"+roomId+"||"+paidAmount+"||"+checkInDate+"||"+checkOutDate+"||");
            
            // 2. 예약 정보 저장
            boolean reservationSuccess = paymentService.saveReservation(userId, roomId, checkInDate, checkOutDate, paidAmount);
            System.out.println("3. 예약 저장 성공 여부: " + reservationSuccess);

            if (reservationSuccess) {
                int reservationId = paymentService.getLatestReservationId(userId, roomId);
                System.out.println("4. 최신 예약 ID: " + reservationId);

                String paymentKey = paymentData.get("imp_uid").toString();
                boolean paymentSuccess = paymentService.savePayment(reservationId, "CARD", paidAmount, paymentKey);
                System.out.println("5. 결제 저장 성공 여부: " + paymentSuccess);

                response.put("result", paymentSuccess ? "success" : "failure");
                response.put("message", paymentSuccess ? "결제가 완료되었습니다." : "결제 정보 저장 실패");
                System.out.println("결제 정보 저장에 실패했습니당."); 
            } else {
                response.put("result", "failure");
                response.put("message", "예약 정보 저장 실패");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.put("result", "failure");
            response.put("message", "에러발생: " + e.getMessage());
        }
        return response;
    }
 // 예약 취소 메서드 추가
    @PostMapping("/cancelReservation")
    @ResponseBody
    public Map<String, Object> cancelReservation(@RequestBody Map<String, String> requestData) {
        Map<String, Object> response = new HashMap<>();
        String reservationId = requestData.get("reservationId");

        try {
        	// 결제 키를 조회하고, 이를 사용하여 결제 취소 요청을 보냅니다.
            String paymentKey = paymentService.getPaymentKeyFromReservation(reservationId); // 예약 ID로 결제 키 조회
            if (paymentKey != null) {
                boolean cancelResult = paymentService.cancelPayment(paymentKey); // 결제 취소 API 호출

                if (cancelResult) {
                    // 결제 취소 성공 시 DB 예약 상태, 결제 상태 업데이트
                	paymentService.updatePaymentStatus(reservationId, "CANCELLED");
                    paymentService.updateReservationStatus(reservationId, "CANCELLED");
                    response.put("success", true);
                    response.put("message", "예약이 성공적으로 취소되었습니다.");
                } else {
                    response.put("success", false);
                    response.put("message", "결제 취소에 실패했습니다.");
                }
            } else {
                response.put("success", false);
                response.put("message", "결제 키를 찾을 수 없습니다.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.put("success", false);
            response.put("message", "에러 발생: " + e.getMessage());
        }

        return response;
    }
}