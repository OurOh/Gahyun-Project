package com.gahyun.dev.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    // 결제 정보 가져오기 (결제 전 사용자 정보, 금액 등 제공)
    @GetMapping("/getPaymentDetails")
    @ResponseBody
    public Map<String, Object> getPaymentDetails(@RequestParam("userId") int userId) {
        return paymentService.getPaymentDetails(userId);  // 유저 ID에 따른 결제 정보를 가져옴
    }

    // 결제 완료 후 처리
    @PostMapping("/complete")
    @ResponseBody
    public Map<String, Object> paymentComplete(@RequestBody Map<String, Object> paymentData) {
        try {
            String impUid = (String) paymentData.get("imp_uid");
            String merchantUid = (String) paymentData.get("merchant_uid");
            Double paidAmount = (Double) paymentData.get("paid_amount");
            Integer userId = (Integer) paymentData.get("userId");
            Integer roomId = (Integer) paymentData.get("roomId");
            String checkInDateStr = (String) paymentData.get("checkInDate");
            String checkOutDateStr = (String) paymentData.get("checkOutDate");

            // String 날짜를 java.sql.Date로 변환
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date checkInDate = new Date(dateFormat.parse(checkInDateStr).getTime());
            Date checkOutDate = new Date(dateFormat.parse(checkOutDateStr).getTime());

            // 결제 및 예약 정보 저장
            boolean success = paymentService.saveReservation(userId, roomId, checkInDate, checkOutDate, paidAmount);

            if (success) {
                return Map.of("result", "success");
            } else {
                return Map.of("result", "failure");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Map.of("result", "failure");
        }
    }
}
