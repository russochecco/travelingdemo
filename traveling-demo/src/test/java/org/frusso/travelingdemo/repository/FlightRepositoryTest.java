package org.frusso.travelingdemo.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;

import org.frusso.travelingdemo.TravelingDemoApplication;
import org.frusso.travelingdemo.domain.Flight;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TravelingDemoApplication.class)
public class FlightRepositoryTest {
	
	private final String number = "BA1234"; 

	@Autowired
	private FlightRepository flightRepository;

	@Test
	public void addNewFlightTest() throws ParseException {
		
		Flight flight = new Flight();
		flight.setNumber(number);
		flight.setDeparture("Departure");
		flight.setDestination("Destination");
		flight.setPrice("Price");
		flight.setStatus("Status");
		flight.setTimeDeparture(LocalTime.of(8, 0));
		flight.setTimeArrival(LocalTime.of(12, 0));
		flight.setType("Type");
		flight.setDate(LocalDate.of(2015, 9, 30));
		flightRepository.save(flight);
		Flight found = flightRepository.findByNumber(flight.getNumber());
		assertEquals(flight, found);
		
	}

	@Test
	public void deleteFlightTest() {

		Flight found = flightRepository.findByNumber(number);
		
		assertNotNull(found);
		
		flightRepository.delete(found);
		
		assertNull(flightRepository.findByNumber(number));
		
	}

}
