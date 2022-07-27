package com.upgrad.bookmyticket.repository;

import com.upgrad.bookmyticket.entity.Bus;
import com.upgrad.bookmyticket.enums.Destination;
import com.upgrad.bookmyticket.enums.Source;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusRepository extends CrudRepository<Bus, String> {

    List<Bus> findBySourceAndDestination(Source source, Destination destination);

}
