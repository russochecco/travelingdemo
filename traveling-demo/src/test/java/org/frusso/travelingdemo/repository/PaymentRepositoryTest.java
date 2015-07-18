package org.frusso.travelingdemo.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.stream.Collectors;

import org.frusso.travelingdemo.TravelingDemoApplication;
import org.frusso.travelingdemo.domain.Booking;
import org.frusso.travelingdemo.domain.Guest;
import org.frusso.travelingdemo.domain.GuestBaggage;
import org.frusso.travelingdemo.domain.Payment;
import org.frusso.travelingdemo.utils.ParseData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TravelingDemoApplication.class)
public class PaymentRepositoryTest {

	@Autowired
	private PaymentRepository paymentRepository;

	@Autowired
	private BookingRepository bookingRepository;

	@Autowired
	private GuestRepository guestRepository;

	@Autowired
	private GuestBaggageRepository guestBaggageRepository;

	@Test
	public void addNewPaymentTest() {

		String amountExpected = "600.0";
		Guest guest = guestRepository.findOne(1L);
		List<Booking> bookings = bookingRepository.findByGuest(guest);
		Booking booking = bookings.get(0);
		double amount = Double.parseDouble(booking.getFlight().getPrice());
		List<String> partials = guestBaggageRepository.findByGuest(guest).stream().filter(b -> b.getFlight().getNumber().equals(booking.getFlight().getNumber())).map(b -> b.getBaggage().getPrice())
				.collect(Collectors.toList());
		for (String p : partials) {
			amount += Double.parseDouble(p);
		}

		assertEquals(amountExpected, String.valueOf(amount));

		Payment underTest = new Payment();
		underTest.setAmount(String.valueOf(amount));
		underTest.setDatePayment(ParseData.stringValue2Date("2015-09-30"));
		paymentRepository.save(underTest);

	}

}
