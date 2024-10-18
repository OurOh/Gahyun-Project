package com.gahyun.dev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gahyun.dev.model.ReservationDTO;
import com.gahyun.dev.service.ReservationService;

@Controller
@RequestMapping("/mypage")
public class MyPageController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping
    public String showMyPage(Model model) {
        // 현재 예약 정보
        List<ReservationDTO> currentReservations = reservationService.getCurrentReservations();
        // 과거 예약 정보
        List<ReservationDTO> pastReservations = reservationService.getPastReservations();

        model.addAttribute("currentReservations", currentReservations);
        model.addAttribute("pastReservations", pastReservations);

        return "mypage";
    }
}
