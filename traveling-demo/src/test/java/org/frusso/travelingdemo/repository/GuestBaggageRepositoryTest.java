package org.frusso.travelingdemo.repository;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.frusso.travelingdemo.TravelingDemoApplication;
import org.frusso.travelingdemo.domain.Baggage;
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

	@Test
	public void addNewGuestBaggageTest() {

		Passport passport = new Passport();
		passport.setCountry("Italy");
		passport.setDateExpire(ParseData.stringValue2Date("2018-09-20"));
		passport.setNumber("AAPP124");
		passport = passportRepository.saveAndFlush(passport);

		Guest newGuest = new Guest();
		newGuest.setFirstName("John");
		newGuest.setLastName("Martin");
		newGuest.setDateBirth(ParseData.stringValue2Date("1973-09-12"));
		newGuest.setPassport(passport);
		newGuest.setTitle("Mr");
		newGuest = guestRepository.saveAndFlush(newGuest);

		Baggage baggage = baggageRepository.findByQuantityAndType("20kg", "Sports Equipment");

		GuestBaggage newGuestBaggage = new GuestBaggage();
		newGuestBaggage.setBaggage(baggage);
		newGuestBaggage.setGuest(newGuest);
		guestBaggageRepository.saveAndFlush(newGuestBaggage);

		GuestBaggage found = guestBaggageRepository.findByGuest(newGuest).get(0);
		assertTrue(found.getGuest().equals(newGuest));
		assertTrue(found.getBaggage().getId().equals(baggage.getId()));
	}

	@Test
	public void deleteGuestBaggageTest() {

		Guest guest = guestRepository.findByLastName("Rossi");
		List<GuestBaggage> found = guestBaggageRepository.findByGuest(guest);
		guestBaggageRepository.delete(found);
		assertTrue(guestBaggageRepository.findByGuest(guest).size() == 0);
	}

}
