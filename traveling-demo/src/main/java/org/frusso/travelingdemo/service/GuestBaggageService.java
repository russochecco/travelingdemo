package org.frusso.travelingdemo.service;

import java.util.List;

import org.frusso.travelingdemo.domain.Guest;
import org.frusso.travelingdemo.domain.GuestBaggage;

public interface GuestBaggageService {
	
	List<GuestBaggage> findGuestBaggageByGuest(Guest guest);
	
	GuestBaggage save(GuestBaggage guestBaggage);
	
	void delete(GuestBaggage guestBaggage);

}
