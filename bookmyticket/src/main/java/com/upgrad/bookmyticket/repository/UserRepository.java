package com.upgrad.bookmyticket.repository;

import com.upgrad.bookmyticket.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

	@Override
	List<User> findAll();

	//------------------//
	//specify a method that returns User by finding it by email id
	User findByEmailId(String emailId);

}
