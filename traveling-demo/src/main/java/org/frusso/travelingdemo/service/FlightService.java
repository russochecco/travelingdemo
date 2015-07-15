package org.frusso.travelingdemo.service;

import java.util.List;

import org.frusso.travelingdemo.domain.Flight;

public interface FlightService {

	List<Flight> findAll();
	
	Flight findByDeparture(String departure);

	Flight save(Flight flight);

	void delete(Flight flight);
	
}
