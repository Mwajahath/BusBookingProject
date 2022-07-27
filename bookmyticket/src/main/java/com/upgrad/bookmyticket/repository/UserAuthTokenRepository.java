package com.upgrad.bookmyticket.repository;

import com.upgrad.bookmyticket.entity.UserAuthToken;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;

@Repository
public interface UserAuthTokenRepository extends CrudRepository<UserAuthToken, String> {


	UserAuthToken findTopByUserEmailIdOrderByLoginAtDesc(@NotNull String emailId);

	UserAuthToken findByAccessToken(String token);

}
