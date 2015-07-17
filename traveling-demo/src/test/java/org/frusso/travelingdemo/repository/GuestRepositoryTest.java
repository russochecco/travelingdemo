package org.frusso.travelingdemo.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.frusso.travelingdemo.TravelingDemoApplication;
import org.frusso.travelingdemo.domain.Guest;
import org.frusso.travelingdemo.domain.Passport;
import org.frusso.travelingdemo.utils.ParseData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TravelingDemoApplication.class)
public class GuestRepositoryTest {

	@Autowired
	private GuestRepository guestRepository;

	@Autowired
	private PassportRepository passportRepository;

	@Test
	public void addNewGuestTest() {

		Passport passport = new Passport();
		passport.setCountry("Italy");
		passport.setDateExpire(ParseData.stringValue2Date("2018-09-30"));
		passport.setNumber("AAPP123");
		passport = passportRepository.saveAndFlush(passport);

		Guest newGuest = new Guest();
		newGuest.setFirstName("Luca");
		newGuest.setLastName("Bianchi");
		newGuest.setDateBirth(ParseData.stringValue2Date("1973-09-22"));
		newGuest.setPassport(passport);
		newGuest.setTitle("Mr");
		guestRepository.save(newGuest);

		assertEquals(newGuest, guestRepository.findByLastName(newGuest.getLastName()));
	}

	@Test
	public void deleteGuestTest() {

		List<Guest> existings = guestRepository.findAll();
		Guest underTest = existings.get(0);
		String lastName = underTest.getLastName();
		guestRepository.delete(underTest);

		underTest = guestRepository.findByLastName(lastName);
		assertNull(underTest);
	}
}
