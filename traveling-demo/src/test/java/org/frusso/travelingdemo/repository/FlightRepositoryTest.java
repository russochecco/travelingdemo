package org.frusso.travelingdemo.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.text.ParseException;
import java.util.List;

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

	@Autowired
	private FlightRepository flightRepository;

	@Test
	public void addNewFlightTest() throws ParseException {
		Flight newFlight = new Flight();
		newFlight.setNumber("AA1234");
		newFlight.setDeparture("Departure");
		newFlight.setDestination("Destination");
		newFlight.setPrice("Price");
		newFlight.setStatus("Status");
		newFlight.setTimeDeparture("08:00:00");
		newFlight.setTimeArrival("12:00:00");
		newFlight.setType("Type");
		newFlight.setDate(ParseData.stringValue2Date("2015-09-30"));
		flightRepository.save(newFlight);

		Flight found = flightRepository.findByNumber(newFlight.getNumber());
		assertEquals(newFlight, found);
	}

	@Test
	public void deleteFlightTest() {

		List<Flight> existings = flightRepository.findAll();
		Flight underTest = existings.get(0);
		String number = underTest.getNumber();
		flightRepository.delete(underTest);

		underTest = flightRepository.findByNumber(number);
		assertNull(underTest);
	}

}
