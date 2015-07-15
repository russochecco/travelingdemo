package org.frusso.travelingdemo.service.jpa;

import java.util.List;

import org.frusso.travelingdemo.domain.Flight;
import org.frusso.travelingdemo.repository.FlightRepository;
import org.frusso.travelingdemo.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("flightService")
@Repository
@Transactional
public class FlightServiceImpl implements FlightService {
	
	@Autowired
	private FlightRepository flightRepository; 

	@Override
	@Transactional(readOnly = true)
	public List<Flight> findAll() {
		return flightRepository.findAll();
	}

	@Override
	public Flight save(Flight flight) {
		return flightRepository.save(flight);
	}

	@Override
	public void delete(Flight flight) {
		flightRepository.delete(flight);
	}

	@Override
	public Flight findByDeparture(String departure) {
		return flightRepository.findByDeparture(departure);
	}
	
	//...

}
