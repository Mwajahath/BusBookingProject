package com.upgrad.bookmyticket.service;

import com.upgrad.bookmyticket.entity.Booking;
import com.upgrad.bookmyticket.repository.BookingRepository;
import com.upgrad.bookmyticket.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookingService {


	@Autowired
	private BookingRepository bookingRepository;

	@Autowired
	private UserRepository userRepository;


	public String booking(Booking booking){

	return bookingRepository.save(booking).getBookingId();

		}



}


