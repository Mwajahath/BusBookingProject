package com.upgrad.bookmyconsultation.controller;

import com.upgrad.bookmyconsultation.entity.Bus;
import com.upgrad.bookmyconsultation.enums.Destination;
import com.upgrad.bookmyconsultation.enums.Speciality;
import com.upgrad.bookmyconsultation.exception.InvalidInputException;
import com.upgrad.bookmyconsultation.model.TimeSlot;
import com.upgrad.bookmyconsultation.service.BusService;
import com.upgrad.bookmyconsultation.util.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/bus")
public class BusController {

	@Autowired
	private BusService service;


	@GetMapping("/startingPoint")
	public ResponseEntity<List<String>> getSpeciality() {
		return ResponseEntity.ok(Stream.of(Speciality.values())
				.map(Enum::name)
				.collect(Collectors.toList()));
	}

	@GetMapping("/destination")
	public ResponseEntity<List<String>> getDestination() {
		return ResponseEntity.ok(Stream.of(Destination.values())
				.map(Enum::name)
				.collect(Collectors.toList()));
	}


}