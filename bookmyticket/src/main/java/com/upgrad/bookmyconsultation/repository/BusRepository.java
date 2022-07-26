package com.upgrad.bookmyconsultation.repository;

import com.upgrad.bookmyconsultation.entity.Bus;
import com.upgrad.bookmyconsultation.enums.Speciality;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusRepository extends CrudRepository<Bus, String> {

}
