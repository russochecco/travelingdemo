package org.frusso.travelingdemo.repository;

import org.frusso.travelingdemo.domain.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, Long> {

	Guest findByLastName(String lastName);
}
