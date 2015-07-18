package org.frusso.travelingdemo.repository;

import java.util.Date;
import java.util.List;

import org.frusso.travelingdemo.domain.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, Long> {

	List<Guest> findByLastNameAndDateBirth(String lastName, Date dateBirth);
}
