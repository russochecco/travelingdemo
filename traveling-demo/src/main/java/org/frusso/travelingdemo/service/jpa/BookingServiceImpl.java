package org.frusso.travelingdemo.service.jpa;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.frusso.travelingdemo.domain.Booking;
import org.frusso.travelingdemo.domain.Flight;
import org.frusso.travelingdemo.domain.Guest;
import org.frusso.travelingdemo.repository.BookingRepository;
import org.frusso.travelingdemo.service.BookingService;
import org.frusso.travelingdemo.service.FlightService;
import org.frusso.travelingdemo.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("bookingService")
@Transactional
public class BookingServiceImpl implements BookingService {
	
	@Autowired
	private BookingRepository bookingRepository; 

	@Autowired
	private GuestService guestService;
	
	@Autowired
	private FlightService flightService;
	
	@Override
	public List<Booking> findByGuest(Guest guest) {
		return bookingRepository.findByGuest(guest);
	}

	@Override
	public List<Booking> findByFlight(Flight flight) {
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

	@Override
	public List<Booking> findByGuest(String lastName, String dateBirth) {

		List<Booking> result = new ArrayList<Booking>();
		Optional<Guest> guest = guestService.findByLastNameAndDateBirth(lastName, LocalDate.parse(dateBirth)).stream().findFirst();
		if(guest.isPresent()){
			result = bookingRepository.findByGuest(guest.get());
		}
		
		return result;
		
	}

	@Override
	public List<Booking> findByFlight(String number) {
		
		List<Booking> result = new ArrayList<Booking>();
		Optional<Flight> flight = Optional.of(flightService.findByNumber(number));
		if(flight.isPresent()) {
			result = flight.get().getBookings();
		}

		return result;
		
	}

}
