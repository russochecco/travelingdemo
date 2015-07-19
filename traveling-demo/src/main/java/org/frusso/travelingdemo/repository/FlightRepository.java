package org.frusso.travelingdemo.repository;

import java.time.LocalDate;
import java.util.List;

import org.frusso.travelingdemo.domain.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {

	List<Flight> findByDeparture(String departure);
	
	Flight findByNumber(String number);
	
	List<Flight> findByDestination(String destination);
	
	List<Flight> findByDate(LocalDate date);
	
}
