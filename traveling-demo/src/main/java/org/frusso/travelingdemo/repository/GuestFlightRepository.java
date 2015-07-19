package org.frusso.travelingdemo.repository;

import org.frusso.travelingdemo.domain.Guest;
import org.frusso.travelingdemo.domain.Flight;
import org.frusso.travelingdemo.domain.GuestFlight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestFlightRepository extends JpaRepository<GuestFlight, Long> {

	GuestFlight findByGuest(Guest guest);
	
	GuestFlight findByFlight(Flight flight);
	
}
