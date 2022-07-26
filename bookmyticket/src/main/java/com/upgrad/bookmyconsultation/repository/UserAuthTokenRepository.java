package com.upgrad.bookmyconsultation.repository;

import com.upgrad.bookmyconsultation.entity.UserAuthToken;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;

@Repository
public interface UserAuthTokenRepository extends CrudRepository<UserAuthToken, String> {


	UserAuthToken findTopByUserEmailIdOrderByLoginAtDesc(@NotNull String emailId);

	UserAuthToken findByAccessToken(String token);

}
