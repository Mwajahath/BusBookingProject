package com.upgrad.bookmyticket.controller;

import com.upgrad.bookmyticket.entity.Bus;
import com.upgrad.bookmyticket.enums.Destination;
import com.upgrad.bookmyticket.enums.Source;
import com.upgrad.bookmyticket.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/bus")
public class BusController {

	@Autowired
	private BusService service;


	@GetMapping("/startingPoint")
	public ResponseEntity<List<String>> getSpeciality() {
		return ResponseEntity.ok(Stream.of(Source.values())
				.map(Enum::name)
				.collect(Collectors.toList()));
	}

	@GetMapping("/destination")
	public ResponseEntity<List<String>> getDestination() {
		return ResponseEntity.ok(Stream.of(Destination.values())
				.map(Enum::name)
				.collect(Collectors.toList()));
	}

	@GetMapping
	public ResponseEntity<List<Bus>> getAllBuses(@RequestParam Map<String,String> requestParams) throws Exception{
		String source=requestParams.get("source");
		String destination=requestParams.get("destination");
		return ResponseEntity.ok(service.getAllBusesWithFilters(source,destination));
	}


}