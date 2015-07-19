package org.frusso.travelingdemo.service;

import java.time.LocalDate;
import java.util.List;

import org.frusso.travelingdemo.domain.Guest;

public interface GuestService {

	List<Guest> findByLastNameAndDateBirth(String lastName, LocalDate dateBirth);

	Guest findById(String id);

	Guest save(Guest guest);

	void delete(Guest guest);

}
