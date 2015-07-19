package org.frusso.travelingdemo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.frusso.travelingdemo.domain.Flight;
import org.frusso.travelingdemo.domain.Seat;

public interface FlightService {

	List<Flight> findAll();
	
	List<Flight> findByDeparture(String departure);
	
	Flight findByNumber(String number);
	
	List<Flight> findByDestination(String destination);
	
	List<Flight> findByDate(LocalDate date);
	
	boolean checkAvailableSeat(String number, String seat);
	
	List<String> findBookedSeats(String number);
	
	Map<Integer, Seat> seatsMap(String number);
	
	Flight save(Flight flight);

	void delete(Flight flight);
	
}
