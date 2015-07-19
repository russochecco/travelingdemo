package org.frusso.travelingdemo.service.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.frusso.travelingdemo.TravelingDemoApplication;
import org.frusso.travelingdemo.domain.Booking;
import org.frusso.travelingdemo.domain.Flight;
import org.frusso.travelingdemo.domain.Guest;
import org.frusso.travelingdemo.domain.Seat;
import org.frusso.travelingdemo.repository.BookingRepository;
import org.frusso.travelingdemo.repository.GuestRepository;
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
	private GuestRepository guestRepository;
	
	@Autowired
	private BookingRepository bookingRepository;

	@Test
	public void checkAvailableSeatTest() {
		
		String number = "AA10000";
		Flight flight = flightService.findByNumber(number);
		String seat = bookingRepository.findByFlight(flight).get(0).getSeat();
		assertFalse(flightService.checkAvailableSeat(number, seat));
		String otherSeat = "B3";
		assertTrue(flightService.checkAvailableSeat(number, otherSeat));
		
	}
	
	@Test
	public void findBookedSeatsTest() {
		
		String number = "AA10000";
		Flight flight = flightService.findByNumber(number);
		List<String> bookedSeats = bookingRepository.findByFlight(flight).stream().map(b -> b.getSeat()).collect(Collectors.toList());
		assertEquals(bookedSeats, flightService.findBookedSeats(number));
		assertFalse(bookedSeats.equals(flightService.findBookedSeats("AA20000")));
		
	}
	
	@Test
	public void findFlightsByDate() {
		
		String number = "BA1234";
		LocalDate date = LocalDate.of(2015, 11, 4);
		
		Flight flight = new Flight();
		flight.setNumber(number);
		flight.setDeparture("Departure");
		flight.setDestination("Destination");
		flight.setPrice("Price");
		flight.setStatus("Status");
		flight.setTimeDeparture(LocalTime.of(8, 0));
		flight.setTimeArrival(LocalTime.of(12, 0));
		flight.setType("Type");
		flight.setDate(date);
		
		flightService.save(flight);
		
		List<Flight> flightsFound = flightService.findByDate(date);
		assertTrue(flightsFound.contains(flight));
		assertTrue(flightsFound.size() == 1);
 		
		flightService.delete(flight);
		
		flightsFound = flightService.findByDate(date);
		assertTrue(flightsFound.size() == 0);
		
	}
	
	@Test
	public void generateFlightSeatsMapTest() {
		
		Guest guest = guestRepository.findOne(1L);
		Flight flight = guest.getBookings().get(0).getFlight();
	    Map<Integer, Seat>	seatsMap = flightService.seatsMap(flight.getNumber());
	    List<Booking> bookings = bookingRepository.findByFlight(flight);
	    String seat = bookings.get(0).getSeat();
	    Optional<String> found = seatsMap.entrySet().stream().filter(e -> e.getValue().getSeat().equals(seat)).map(e-> e.getValue().getSatus()).findFirst();
	    
	    assertEquals("sold-out", found.get());

	}
	
}
