package org.frusso.travelingdemo.service.jpa;

import java.util.List;

import org.frusso.travelingdemo.domain.Guest;
import org.frusso.travelingdemo.domain.GuestBaggage;
import org.frusso.travelingdemo.repository.GuestBaggageRepository;
import org.frusso.travelingdemo.service.GuestBaggageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("guestBaggageService")
@Transactional
public class GuestBaggageServiceImpl implements GuestBaggageService  {

	@Autowired
	private GuestBaggageRepository guestBaggageRepository;
	
	@Override
	public List<GuestBaggage> findGuestBaggageByGuest(Guest guest) {
		return guestBaggageRepository.findByGuest(guest);
	}

	@Override
	public GuestBaggage save(GuestBaggage guestBaggage) {
		return guestBaggageRepository.save(guestBaggage);
	}

	@Override
	public void delete(GuestBaggage guestBaggage) {
		guestBaggageRepository.delete(guestBaggage);		
	}

}
