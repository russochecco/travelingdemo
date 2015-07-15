package org.frusso.travelingdemo.repository;

import org.frusso.travelingdemo.domain.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {

	Flight findByDeparture(String departure);
}
