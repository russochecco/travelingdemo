package org.frusso.travelingdemo.service;

import java.util.List;

import org.frusso.travelingdemo.domain.Booking;
import org.frusso.travelingdemo.domain.Flight;
import org.frusso.travelingdemo.domain.Guest;

public interface BookingService {

	List<Booking> findBookingByGuest(Guest guest);

	List<Booking> findBookingByFlight(Flight flight);

	Booking save(Booking booking);

	void delete(Booking booking);
	
}
