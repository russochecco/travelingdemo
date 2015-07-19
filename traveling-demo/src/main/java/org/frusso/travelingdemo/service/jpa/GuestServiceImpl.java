package org.frusso.travelingdemo.service.jpa;

import java.time.LocalDate;
import java.util.List;

import org.frusso.travelingdemo.domain.Guest;
import org.frusso.travelingdemo.repository.GuestRepository;
import org.frusso.travelingdemo.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("guestService")
@Transactional
public class GuestServiceImpl implements GuestService {

	@Autowired
	private GuestRepository guestRepository;
	
	@Override
	public List<Guest> findByLastNameAndDateBirth(String lastName, LocalDate dateBirth) {
		return guestRepository.findByLastNameAndDateBirth(lastName, dateBirth);
	}

	@Override
	public Guest findById(String id) {
		return guestRepository.findOne(Long.getLong(id));
	}
	
	@Override
	public Guest save(Guest guest) {
		return guestRepository.save(guest);
	}

	@Override
	public void delete(Guest guest) {
		guestRepository.save(guest);
	}

}
