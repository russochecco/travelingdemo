package org.frusso.travelingdemo.repository;

import java.util.List;

import org.frusso.travelingdemo.domain.Booking;
import org.frusso.travelingdemo.domain.Flight;
import org.frusso.travelingdemo.domain.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {

	List<Booking> findByGuest(Guest guest);
	
	List<Booking> findByFlight(Flight flight);

}
