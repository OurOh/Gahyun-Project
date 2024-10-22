package com.gahyun.dev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gahyun.dev.service.PaymentService;
import com.siot.IamportRestClient.response.Payment;

@Controller
@RequestMapping("/payment")
public class PaymentsController {
    @Autowired
       private PaymentService paymentService;

       @GetMapping("/page")
       public String paymentPage(Model model) {
           Payment payment = paymentService.getPaymentDetails();
           if (payment != null) {
               model.addAttribute("payment", payment);
           } else {
               model.addAttribute("error", "결제 정보를 찾을 수 없습니다.");
           }
           return "paymentSuccess";
       }
}
