package org.frusso.travelingdemo.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

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
	private PassportRepository passportRepository;

	@Autowired
	private BookingRepository bookingRepository;

	@Autowired
	private FlightRepository flightRepository;

	@Before
	public void setUp() throws Exception {

		// find by id...
		guest = guestRepository.findOne(1L);
		flight = flightRepository.findOne(1L);
	}

	@Test
	public void addNewBooking() {

		Booking underTest = new Booking();
		underTest.setGuest(guest);
		underTest.setFlight(flight);
		underTest.setDateBooking(ParseData.stringValue2Date("2015-08-26"));
		underTest.setSeat("A2");
		underTest = bookingRepository.save(underTest);

		Booking found = bookingRepository.findOne(underTest.getId());
		assertEquals(underTest, found);
	}

	@Test
	public void deleteBookingTest() {

		Booking found = bookingRepository.findOne(2L);
		assertNotNull(found);
		bookingRepository.delete(found);
		assertNull(bookingRepository.findOne(found.getId()));
	}
}
