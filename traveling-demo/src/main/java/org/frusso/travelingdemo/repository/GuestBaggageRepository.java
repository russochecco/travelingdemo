package org.frusso.travelingdemo.repository;

import java.util.List;

import org.frusso.travelingdemo.domain.Baggage;
import org.frusso.travelingdemo.domain.Flight;
import org.frusso.travelingdemo.domain.Guest;
import org.frusso.travelingdemo.domain.GuestBaggage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestBaggageRepository extends JpaRepository<GuestBaggage, Long> {

	List<GuestBaggage> findByGuest(Guest guest);
	
	GuestBaggage findByGuestAndFlightAndBaggage(Guest guest, Flight flight, Baggage baggage);
		
}
