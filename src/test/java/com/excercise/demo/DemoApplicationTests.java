package com.excercise.demo;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import com.excercise.demo.models.Reservation;
import com.excercise.demo.repositories.ReservationRepository;

@SpringBootTest
class DemoApplicationTests {
	
	@Autowired
	private ReservationRepository reservationRepository;

	@Test
	void insertReservation() {
		Reservation reservation = reservationRepository.save(new Reservation("Test reservation", LocalDateTime.now()));
		Assert.notNull(reservation, "Reservation not created");
	}

	@Test
	void validateSampleData() {
		try {
			InputStream inputStream = getClass().getClassLoader().getResourceAsStream("sampleData");
			InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
			streamReader.close();
		} catch (Exception e) {
			Assert.isTrue(false, "sampleData file for not found");
		}
	}

}
