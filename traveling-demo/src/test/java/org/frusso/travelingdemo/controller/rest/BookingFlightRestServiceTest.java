package org.frusso.travelingdemo.controller.rest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.apache.log4j.Logger;
import org.frusso.travelingdemo.TravelingDemoApplication;
import org.frusso.travelingdemo.domain.dto.CreditCardDTO;
import org.frusso.travelingdemo.domain.dto.FlightDTO;
import org.frusso.travelingdemo.domain.dto.GuestDTO;
import org.frusso.travelingdemo.domain.dto.PassportDTO;
import org.frusso.travelingdemo.service.FlightService;
import org.frusso.travelingdemo.service.GuestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TravelingDemoApplication.class)
@WebAppConfiguration
@IntegrationTest("server.port=9000")
public class BookingFlightRestServiceTest {

	private final Logger logger = Logger.getLogger(BookingFlightRestServiceTest.class);
	private final RestTemplate restTemplate = new TestRestTemplate();

	@Autowired
	private FlightService flightService;

	@Autowired
	private GuestService guestService;

	@Test
	public void findAllTest() {

		ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:9000/booking-flight/flight-all", String.class);
		assertTrue(response.getStatusCode().is2xxSuccessful());
		logger.info(response.getBody());

	}

	@Test
	public void findFlightsByDepartureTest() {

		ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:9000/booking-flight/flight-by-departure?departure=Hong Kong (HKG)", String.class);
		assertTrue(response.getStatusCode().is2xxSuccessful());
		assertTrue(response.getBody().contains("Hong Kong (HKG)"));
		logger.info(response.getBody());

	}

	@Test
	public void addFlightTest() {

		FlightDTO flight = new FlightDTO("AA40000", "Hong Kong (HKG)", "Kunming (KMG)", "2015-10-05", "09:20", "14:20", "available", "250.0", "HK Express");
		FlightDTO saved = restTemplate.postForObject("http://localhost:9000/booking-flight/flight-add", flight, FlightDTO.class);
		assertNotNull(saved);
		assertNotNull(flightService.findByNumber("AA40000"));
		logger.info(saved);

	}

	@Test
	public void findFlightByNumberTest() {

		FlightDTO response = restTemplate.getForObject("http://localhost:9000//booking-flight/flight-by-number?number=AA10000", FlightDTO.class);
		assertNotNull(response);
		assertEquals(response.getNumber(), "AA10000");
		logger.info(response);

	}

	@Test
	public void flightBaggagesTypeTest() {

		ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:9000/booking-flight/flight-baggages-type", String.class);
		assertTrue(response.getStatusCode().is2xxSuccessful());
		logger.info(response.getBody());

	}

	@Test
	public void flightSeatsMapTest() {

		ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:9000/booking-flight/flight-seats-map?number=AA10000", String.class);
		assertTrue(response.getStatusCode().is2xxSuccessful());
		logger.info(response.getBody());

	}

	@Test
	public void checkSeatTest() {

		String response = restTemplate.getForObject("http://localhost:9000//booking-flight/flight-check-seat?number=AA10000&seat=A1", String.class);
		assertTrue(response.equals("sold-out"));
		logger.info(response);

	}

	@Test
	public void bookedSeatsTest() {

		ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:9000/booking-flight/flight-boocked-seats?number=AA10000", String.class);
		assertTrue(response.getStatusCode().is2xxSuccessful());
		logger.info(response.getBody());

	}

	@Test
	public void findFlightBookingsTest() {

		ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:9000/booking-flight/flight-boockings?number=AA10000", String.class);
		assertTrue(response.getStatusCode().is2xxSuccessful());
		logger.info(response.getBody());

	}

	@Test
	public void findGuestBookingsTest() {

		ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:9000/booking-flight/guest-boockings?lastName=Rossi&dateBirth=1973-11-22", String.class);
		assertTrue(response.getStatusCode().is2xxSuccessful());
		logger.info(response.getBody());

	}

	@Test
	public void addGuestTest() {

		GuestDTO guest = new GuestDTO();
		guest.setFirstName("Luca");
		guest.setLastName("Bianchi");
		guest.setDateBirth(LocalDate.parse("1973-09-22").toString());
		guest.setTitle("Mr");

		PassportDTO passport = new PassportDTO();
		passport.setCountry("Italy");
		passport.setDateExpire(LocalDate.parse("2018-09-30").toString());
		passport.setNumber("AAPP123");

		guest.setPassport(passport);

		CreditCardDTO creditCard = new CreditCardDTO();
		creditCard.setNumber("BBBBDDD12");
		creditCard.setCreditCardType("Visa");
		creditCard.setDateExpire(LocalDate.parse("2020-09-30").toString());

		guest.setCreditCard(creditCard);

		GuestDTO saved = restTemplate.postForObject("http://localhost:9000/booking-flight/guest-add", guest, GuestDTO.class);
		assertNotNull(saved);
		assertNotNull(guestService.findByLastNameAndDateBirth("Bianchi", LocalDate.parse("1973-09-22")).stream().findFirst().get());
		logger.info(saved);

	}

}
