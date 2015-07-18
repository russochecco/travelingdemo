package org.frusso.travelingdemo.service.jpa;

import java.util.List;

import org.frusso.travelingdemo.domain.Booking;
import org.frusso.travelingdemo.domain.Flight;
import org.frusso.travelingdemo.domain.Guest;
import org.frusso.travelingdemo.repository.BookingRepository;
import org.frusso.travelingdemo.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("bookingService")
@Transactional
public class BookingServiceImpl implements BookingService {
	
	@Autowired
	private BookingRepository bookingRepository; 

	@Override
	public List<Booking> findBookingByGuest(Guest guest) {
		return bookingRepository.findByGuest(guest);
	}

	@Override
	public List<Booking> findBookingByFlight(Flight flight) {
		return bookingRepository.findByFlight(flight);
	}

	@Override
	public Booking save(Booking booking) {
		return bookingRepository.save(booking);
	}

	@Override
	public void delete(Booking booking) {
		bookingRepository.delete(booking);
	}

}
