package org.frusso.travelingdemo.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.time.LocalDate;

import org.frusso.travelingdemo.TravelingDemoApplication;
import org.frusso.travelingdemo.domain.CreditCard;
import org.frusso.travelingdemo.domain.Guest;
import org.frusso.travelingdemo.domain.Passport;
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
	private CreditCardRepository creditCardRepository;

	@Autowired
	private PassportRepository passportRepository;

	@Test
	public void addNewGuestTest() {

		Guest guest = new Guest();
		guest.setFirstName("Luca");
		guest.setLastName("Bianchi");
		guest.setDateBirth(LocalDate.parse("1973-09-22"));
		guest.setTitle("Mr");

		Passport passport = new Passport();
		passport.setCountry("Italy");
		passport.setDateExpire(LocalDate.parse("2018-09-30"));
		passport.setNumber("AAPP123");
		passport.setGuest(guest);
		guest.setPassport(passport);

		CreditCard creditCard = new CreditCard();
		creditCard.setNumber("BBBBDDD12");
		creditCard.setCreditCardType("Visa");
		creditCard.setDateExpire(LocalDate.parse("2020-09-30"));
		creditCard.setGuest(guest);
		guest.setCreditCard(creditCard);

		guest = guestRepository.save(guest);

		assertEquals(guest, guestRepository.findOne(guest.getId()));
		assertNotNull(creditCardRepository.findOne(guest.getCreditCard().getId()));
		assertNotNull(passportRepository.findOne(guest.getPassport().getId()));

	}

	@Test
	public void deleteGuestTest() {

		Guest found = guestRepository.findOne(1L);
		
		assertNotNull(found);

		guestRepository.delete(found);

		assertNull(guestRepository.findOne(found.getId()));

	}
}
