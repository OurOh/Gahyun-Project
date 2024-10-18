package com.gahyun.dev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gahyun.dev.mapper.ReservationMapper;
import com.gahyun.dev.model.ReservationDTO;

@Service
public class ReservationService {

    @Autowired
    private ReservationMapper reservationMapper;

    public List<ReservationDTO> getCurrentReservations() {
        return reservationMapper.findCurrentReservations();
    }

    public List<ReservationDTO> getPastReservations() {
        return reservationMapper.findPastReservations();
    }
}
