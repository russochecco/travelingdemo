package org.frusso.travelingdemo.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.time.LocalDate;

import org.frusso.travelingdemo.TravelingDemoApplication;
import org.frusso.travelingdemo.domain.Booking;
import org.frusso.travelingdemo.domain.Flight;
import org.frusso.travelingdemo.domain.Guest;
import org.frusso.travelingdemo.utils.ParseData;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TravelingDemoApplication.class)
public class BookingRepositoryTest {

	private Guest guest;
	private Flight flight;

	@Autowired
	private GuestRepository guestRepository;

	@Autowired
	private BookingRepository bookingRepository;

	@Autowired
	private FlightRepository flightRepository;

	@Autowired
	private GuestBaggageRepository guestBaggageRepository;

	@Before
	public void setUp() throws Exception {

		guest = guestRepository.findByLastNameAndDateBirth("Rossi", LocalDate.parse("1973-11-22")).get(0);
		flight = flightRepository.findByNumber("AA10000");

	}

	@Test
	public void addNewBooking() {

		Booking booking = new Booking();
		booking.setGuest(guest);
		booking.setFlight(flight);
		booking.setDateBooking(LocalDate.parse("2015-08-26"));
		booking.setSeat("A3");
		
		booking = bookingRepository.save(booking);
		
		assertEquals(booking, bookingRepository.findOne(booking.getId()));

	}

	@Test
	public void makeBookingPaymentTest() {

		Booking booking = bookingRepository.findByGuestAndFlightAndDateBookingAndSeat(guest, flight, ParseData.stringValue2Date("2015-08-01"), "A1");
		booking.setAmount("600.0");
		booking.setDatePayment(LocalDate.parse("2015-07-18"));
		
		booking = bookingRepository.save(booking);
		
		Booking found = bookingRepository.findOne(booking.getId());
		
		assertEquals(booking.getDatePayment(), found.getDatePayment());
		assertEquals(booking.getAmount(), found.getAmount());
		
	}

	@Test
	public void deleteBookingTest() {

		Booking found = bookingRepository.findByGuestAndFlightAndDateBookingAndSeat(guest, flight, ParseData.stringValue2Date("2015-08-01"), "A1");
		
		assertNotNull(found);
		
		bookingRepository.delete(found);
		
		assertNull(bookingRepository.findOne(found.getId()));

	}
}
