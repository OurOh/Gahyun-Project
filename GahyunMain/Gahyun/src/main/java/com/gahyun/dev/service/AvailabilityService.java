package com.gahyun.dev.service;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gahyun.dev.mapper.Room_availabilityMapper;

@Service
public class AvailabilityService {

		@Autowired
		private Room_availabilityMapper availabilityMapper;
		
		public int updateavail(int roomid, LocalDate endDate ,boolean isAvail) {
			
			return availabilityMapper.updateAvailabilityRooms(roomid, endDate, isAvail);
		}

}
