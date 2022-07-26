package com.upgrad.bookmyconsultation.service;

import com.upgrad.bookmyconsultation.entity.Bus;
import com.upgrad.bookmyconsultation.enums.Speciality;
import com.upgrad.bookmyconsultation.exception.InvalidInputException;
import com.upgrad.bookmyconsultation.exception.ResourceUnAvailableException;
import com.upgrad.bookmyconsultation.model.TimeSlot;
import com.upgrad.bookmyconsultation.repository.BookingRepository;
import com.upgrad.bookmyconsultation.repository.BusRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springfox.documentation.annotations.Cacheable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Log4j2
@Service
public class BusService {
	@Autowired
	private BookingRepository appointmentRepository;
	@Autowired
	private BusRepository doctorRepository;


	


}
