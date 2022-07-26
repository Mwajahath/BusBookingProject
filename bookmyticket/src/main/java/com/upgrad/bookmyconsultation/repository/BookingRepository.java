package com.upgrad.bookmyconsultation.repository;


import com.upgrad.bookmyconsultation.entity.Booking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends CrudRepository<Booking, String> {

	public List<Booking> findByUserId(String userId);
}
