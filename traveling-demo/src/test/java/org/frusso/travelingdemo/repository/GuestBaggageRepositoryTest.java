package org.frusso.travelingdemo.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.time.LocalDate;

import org.frusso.travelingdemo.TravelingDemoApplication;
import org.frusso.travelingdemo.domain.Baggage;
import org.frusso.travelingdemo.domain.CreditCard;
import org.frusso.travelingdemo.domain.Flight;
import org.frusso.travelingdemo.domain.Guest;
import org.frusso.travelingdemo.domain.GuestBaggage;
import org.frusso.travelingdemo.domain.Passport;
import org.frusso.travelingdemo.utils.ParseData;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TravelingDemoApplication.class)
public class GuestBaggageRepositoryTest {

	private Guest guest;
	private Passport passport;
	private CreditCard creditCard;
	private Baggage baggage;
	private Flight flight;

	@Autowired
	private GuestRepository guestRepository;

	@Autowired
	private BaggageRepository baggageRepository;

	@Autowired
	private GuestBaggageRepository guestBaggageRepository;

	@Autowired
	private FlightRepository flightRepository;

	@Before
	public void setUp() {

		guest = new Guest();
		guest.setFirstName("Luca");
		guest.setLastName("Bianchi");
		guest.setDateBirth(LocalDate.parse("1973-09-22"));
		guest.setTitle("Mr");

		passport = new Passport();
		passport.setCountry("Italy");
		passport.setDateExpire(LocalDate.parse("2018-09-30"));
		passport.setNumber("AAPP123");
		passport.setGuest(guest);

		guest.setPassport(passport);

		creditCard = new CreditCard();
		creditCard.setNumber("BBBBDDD12");
		creditCard.setCreditCardType("Visa");
		creditCard.setDateExpire(LocalDate.parse("2020-09-30"));
		creditCard.setGuest(guest);

		guest.setCreditCard(creditCard);

		guest = guestRepository.save(guest);

		baggage = baggageRepository.findByQuantityAndType("20kg", "Sports Equipment");
		flight = flightRepository.findByNumber("AA10000");

	}

	@Test
	public void addNewGuestBaggageTest() {

		GuestBaggage guestBaggage = new GuestBaggage();
		guestBaggage.setGuest(guest);
		guestBaggage.setBaggage(baggage);
		guestBaggage.setFlight(flight);
		
		guestBaggage = guestBaggageRepository.save(guestBaggage);

		GuestBaggage found = guestBaggageRepository.findOne(guestBaggage.getId());
		
		assertEquals(found.getGuest(), guest);
		assertEquals(found.getBaggage(), baggage);
		assertEquals(found.getFlight(), flight);

	}

	@Test
	@Ignore
	public void deleteGuestBaggageTest() {

		GuestBaggage guestBaggage = new GuestBaggage();
		guestBaggage.setGuest(guest);
		guestBaggage.setBaggage(baggage);
		guestBaggage.setFlight(flight);
		
		guestBaggage = guestBaggageRepository.save(guestBaggage);

		GuestBaggage found = guestBaggageRepository.findByGuestAndFlightAndBaggage(guest, flight, baggage);
		
		assertNotNull(found);
		
		guestBaggageRepository.delete(found);
		
		assertNull(guestBaggageRepository.findOne(found.getId()));

	}

}
