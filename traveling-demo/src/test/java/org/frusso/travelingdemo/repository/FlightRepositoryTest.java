package org.frusso.travelingdemo.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.text.ParseException;

import org.frusso.travelingdemo.TravelingDemoApplication;
import org.frusso.travelingdemo.domain.Flight;
import org.frusso.travelingdemo.utils.ParseData;
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
		flight.setTimeDeparture("08:00:00");
		flight.setTimeArrival("12:00:00");
		flight.setType("Type");
		flight.setDate(ParseData.stringValue2Date("2015-09-30"));
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
