package org.frusso.travelingdemo.repository;

import java.time.LocalDate;
import java.util.List;

import org.frusso.travelingdemo.domain.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, Long> {

	List<Guest> findByLastNameAndDateBirth(String lastName, LocalDate dateBirth);

}
