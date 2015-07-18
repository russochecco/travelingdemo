package org.frusso.travelingdemo.repository;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.frusso.travelingdemo.TravelingDemoApplication;
import org.frusso.travelingdemo.domain.Baggage;
import org.frusso.travelingdemo.domain.CreditCard;
import org.frusso.travelingdemo.domain.Flight;
import org.frusso.travelingdemo.domain.Guest;
import org.frusso.travelingdemo.domain.GuestBaggage;
import org.frusso.travelingdemo.domain.Passport;
import org.frusso.travelingdemo.utils.ParseData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TravelingDemoApplication.class)
public class GuestBaggageRepositoryTest {

	@Autowired
	private GuestRepository guestRepository;

	@Autowired
	private BaggageRepository baggageRepository;

	@Autowired
	private GuestBaggageRepository guestBaggageRepository;

	@Autowired
	private PassportRepository passportRepository;
	
	@Autowired
	private FlightRepository flightRepository;
	
	@Autowired
	private CreditCardRepository creditCardRepository;

	@Test
	public void addNewGuestBaggageTest() {

		Passport passport = new Passport();
		passport.setCountry("Italy");
		passport.setDateExpire(ParseData.stringValue2Date("2018-09-20"));
		passport.setNumber("AAPP124");
		passport = passportRepository.saveAndFlush(passport);
		
		CreditCard creditCard = new CreditCard();
		creditCard.setNumber("BBBBDDD124");
		creditCard.setCreditCardType("Visa");
		creditCard.setDateExpire(ParseData.stringValue2Date("2020-09-30"));
		creditCardRepository.saveAndFlush(creditCard);

		Guest newGuest = new Guest();
		newGuest.setFirstName("John");
		newGuest.setLastName("Martin");
		newGuest.setDateBirth(ParseData.stringValue2Date("1973-09-12"));
		newGuest.setPassport(passport);
		newGuest.setCreditCard(creditCard);
		newGuest.setTitle("Mr");
		newGuest = guestRepository.saveAndFlush(newGuest);

		Baggage baggage = baggageRepository.findByQuantityAndType("20kg", "Sports Equipment");

		Flight flight = flightRepository.findByNumber("AA10000");
		
		GuestBaggage newGuestBaggage = new GuestBaggage();
		newGuestBaggage.setBaggage(baggage);
		newGuestBaggage.setGuest(newGuest);
		newGuestBaggage.setFlight(flight);
		guestBaggageRepository.saveAndFlush(newGuestBaggage);

		GuestBaggage found = guestBaggageRepository.findByGuest(newGuest).get(0);
		assertTrue(found.getGuest().equals(newGuest));
		assertTrue(found.getBaggage().getId().equals(baggage.getId()));
	}

	@Test
	public void deleteGuestBaggageTest() {

		Guest guest = guestRepository.findByLastNameAndDateBirth("Rossi", ParseData.stringValue2Date("1973-11-22")).get(0);
		List<GuestBaggage> found = guestBaggageRepository.findByGuest(guest);
		guestBaggageRepository.delete(found);
		assertTrue(guestBaggageRepository.findByGuest(guest).size() == 0);
	}

}
