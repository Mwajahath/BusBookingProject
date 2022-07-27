package com.upgrad.bookmyticket.controller;

import com.upgrad.bookmyticket.entity.Booking;
import com.upgrad.bookmyticket.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/booking")
public class BookingController {

	@Autowired
	private BookingService bookingService;


	@PostMapping(value = "/bookTicket",consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> bookAppointment(@RequestBody Booking booking) {
		String saving = bookingService.booking(booking);
		return new ResponseEntity<>(saving, HttpStatus.CREATED);

	}


}