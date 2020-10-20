package com.excercise.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excercise.demo.models.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer>{
}
