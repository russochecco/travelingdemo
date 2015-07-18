package org.frusso.travelingdemo.service;

import java.util.List;

import org.frusso.travelingdemo.domain.Flight;

public interface FlightService {

	List<Flight> findAll();
	
	Flight findFlightByDeparture(String departure);
	
	Flight findFlightByNumber(String number);
	
	Flight findFlightByDestination(String destination);
	
	boolean checkAvailableSeat(String flightNumber, String seat);
	
	List<String> findBookedSeats(String flightNumber);

	Flight save(Flight flight);

	void delete(Flight flight);
	
}
