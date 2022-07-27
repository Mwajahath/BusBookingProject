/*
 * Copyright 2018-2019, https://beingtechie.io.
 *
 * File: AuthenticationService.java
 * Date: May 5, 2018
 * Author: Thribhuvan Krishnamurthy
 */
package com.upgrad.bookmyticket.service;


import com.upgrad.bookmyticket.entity.User;
import com.upgrad.bookmyticket.entity.UserAuthToken;
import com.upgrad.bookmyticket.exception.ApplicationException;
import com.upgrad.bookmyticket.exception.AuthenticationFailedException;
import com.upgrad.bookmyticket.exception.UserErrorCode;
import com.upgrad.bookmyticket.model.AuthorizedUser;
import com.upgrad.bookmyticket.provider.PasswordCryptographyProvider;
import com.upgrad.bookmyticket.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
public class AuthenticationService {

	@Autowired
	private PasswordCryptographyProvider passwordCryptographyProvider;

	@Autowired
	private UserService userService;

	@Autowired
	private AuthTokenService authTokenService;

	@Autowired
	private UserRepository userRepository;


	@Transactional(propagation = Propagation.REQUIRED)
	public AuthorizedUser authenticate(final String email, final String password) throws ApplicationException {

		User user = userRepository.findByEmailId(email);
		if (user == null) throw new AuthenticationFailedException(UserErrorCode.USR_002);

		final String encryptedPassword = passwordCryptographyProvider.encrypt(password, user.getSalt());
		if (!user.getPassword().equals(encryptedPassword)) {

			throw new AuthenticationFailedException(UserErrorCode.USR_003);
		}
		UserAuthToken userAuthToken = authTokenService.issueToken(user);
		return authorizedUser(user, userAuthToken);


	}

	private AuthorizedUser authorizedUser(final User user, final UserAuthToken userAuthToken) {
		final AuthorizedUser authorizedUser = new AuthorizedUser();
		authorizedUser.setId(user.getEmailId());
		authorizedUser.setFirstName(user.getFirstName());
		authorizedUser.setLastName(user.getLastName());
		authorizedUser.setEmailAddress(user.getEmailId());
		authorizedUser.setMobilePhoneNumber(user.getMobile());
		authorizedUser.setAccessToken(userAuthToken.getAccessToken());
		return authorizedUser;
	}

}
