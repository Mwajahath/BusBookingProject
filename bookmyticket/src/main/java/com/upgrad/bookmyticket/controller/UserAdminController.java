package com.upgrad.bookmyticket.controller;

import com.upgrad.bookmyticket.entity.User;
import com.upgrad.bookmyticket.exception.InvalidInputException;
import com.upgrad.bookmyticket.service.BookingService;
import com.upgrad.bookmyticket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/users")
public class UserAdminController {

	@Autowired
	private UserService userService;

	@Autowired
	private BookingService appointmentService;


	@GetMapping(path = "/{id}")
	public ResponseEntity<User> getUser(@RequestHeader("authorization") String accessToken,
	                                    @PathVariable("id") final String userUuid) {
		final User User = userService.getUser(userUuid);
		return ResponseEntity.ok(User);
	}

	@PostMapping(value = "/register")
	public final ResponseEntity createUser(@RequestBody User user) throws InvalidInputException {
		User user1 = userService.register(user);
		return new ResponseEntity<>(user1,HttpStatus.OK);
	}
	
	




}
