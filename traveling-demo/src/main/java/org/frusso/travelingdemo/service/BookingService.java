package org.frusso.travelingdemo.service;

import java.util.List;

import org.frusso.travelingdemo.domain.Booking;
import org.frusso.travelingdemo.domain.Flight;
import org.frusso.travelingdemo.domain.Guest;

public interface BookingService {

	List<Booking> findByGuest(Guest guest);

	List<Booking> findByFlight(Flight flight);

	List<Booking> findByGuest(String lastname, String dateBirth);

	List<Booking> findByFlight(String number);

	Booking save(Booking booking);

	void delete(Booking booking);
	
}
