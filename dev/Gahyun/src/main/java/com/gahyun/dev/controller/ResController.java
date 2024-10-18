package com.gahyun.dev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.gahyun.dev.mapper.MemberMapper;
import com.gahyun.dev.mapper.ReservationsMapper;
import com.gahyun.dev.mapper.RoomsMapper;



@Controller
public class ResController {
	
	@Autowired
	private MemberMapper userdao;
	
	@Autowired
	private RoomsMapper roomsdao;
	@Autowired
	private ReservationsMapper reservationsdao;
	


}
