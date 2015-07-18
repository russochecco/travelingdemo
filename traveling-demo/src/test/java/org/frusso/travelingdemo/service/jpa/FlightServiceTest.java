package org.frusso.travelingdemo.service.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.stream.Collectors;

import org.frusso.travelingdemo.TravelingDemoApplication;
import org.frusso.travelingdemo.domain.Flight;
import org.frusso.travelingdemo.repository.BookingRepository;
import org.frusso.travelingdemo.service.FlightService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TravelingDemoApplication.class)
public class FlightServiceTest {
	
	@Autowired
	private FlightService flightService;
	
	@Autowired
	private BookingRepository bookingRepository;

	@Test
	public void checkAvailableSeatTest() {
		String flightNumber = "AA10000";
		Flight flight = flightService.findFlightByNumber(flightNumber);
		String seat = bookingRepository.findByFlight(flight).get(0).getSeat();
		assertFalse(flightService.checkAvailableSeat(flightNumber, seat));
		String otherSeat = "B3";
		assertTrue(flightService.checkAvailableSeat(flightNumber, otherSeat));
	}
	
	@Test
	public void findBookedSeatsTest() {
		String flightNumber = "AA10000";
		Flight flight = flightService.findFlightByNumber(flightNumber);
		List<String> bookedSeats = bookingRepository.findByFlight(flight).stream().map(b -> b.getSeat()).collect(Collectors.toList());
		assertEquals(bookedSeats, flightService.findBookedSeats(flightNumber));
		assertFalse(bookedSeats.equals(flightService.findBookedSeats("AA20000")));
	}
	
}
