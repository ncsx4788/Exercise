package com.excercise.demo.controllers;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.excercise.demo.models.Reservation;
import com.excercise.demo.repositories.ReservationRepository;

@RestController
public class ReservationController {
	
	@Autowired 
	private ReservationRepository reservationRepository;
	
	private static final Logger logger = LogManager.getLogger(ReservationController.class);
	
	@GetMapping("/reservations")
	public ResponseEntity<List<Reservation>> getAllReservations() {
		return new ResponseEntity<>(reservationRepository.findAll(),HttpStatus.OK);
	}

}
