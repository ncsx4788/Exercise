package com.excercise.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.excercise.demo.models.Reservation;
import com.excercise.demo.repositories.ReservationRepository;

@Component
public class ReservationsCLR implements CommandLineRunner{
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	private static final Logger logger = LogManager.getLogger(ReservationsCLR.class);

	@Override
	public void run(String... args) throws Exception {
		try
		{
			InputStream inputStream = getClass().getClassLoader().getResourceAsStream("sampleData");
			InputStreamReader streamReader =  new InputStreamReader(inputStream, StandardCharsets.UTF_8);
	        BufferedReader reader = new BufferedReader(streamReader);
	        String reservation;
	        while (( reservation = reader.readLine()) != null) {
	        	String [] data = reservation.split(",");
	        	if(data.length == 2)
	        	{
	        		reservationRepository.save(new Reservation(data[0], getLocalDateTimeFromString(data[1])));
	        	}
	        }
		}
		catch (NullPointerException | IOException  e) {
			logger.error(e.getMessage());
			logger.error("sample data issue, saving default customer");
			reservationRepository.save(new Reservation("Default customer", LocalDateTime.now()));
		}
    }
	
	private static LocalDateTime getLocalDateTimeFromString(String s) {
		LocalDateTime dateTime;
		try 
		{
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    		dateTime = LocalDateTime.parse(s, formatter);
		}
		catch (DateTimeParseException e) {
			logger.error(e.getMessage());
			logger.error("Datetime format incorrect, setting to current datetime");
			dateTime = LocalDateTime.now();
		}
		return dateTime;
	}
}