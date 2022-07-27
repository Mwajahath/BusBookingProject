package com.upgrad.bookmyticket.service;

import com.upgrad.bookmyticket.entity.Bus;
import com.upgrad.bookmyticket.enums.Destination;
import com.upgrad.bookmyticket.enums.Source;
import com.upgrad.bookmyticket.repository.BookingRepository;
import com.upgrad.bookmyticket.repository.BusRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Log4j2
@Service
public class BusService {
	@Autowired
	private BookingRepository bookingRepository;
	@Autowired
	private BusRepository busRepository;


	public List<Bus> getAllBusesWithFilters(String source, String destination) {

		if (source != null && !source.isEmpty() &&destination != null && !destination.isEmpty()) {
			return busRepository.findBySourceAndDestination(Source.valueOf(source), Destination.valueOf(destination));
		}
		return null;
	}





	


}
