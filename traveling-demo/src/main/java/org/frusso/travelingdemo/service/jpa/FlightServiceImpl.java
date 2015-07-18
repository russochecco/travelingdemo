package org.frusso.travelingdemo.service.jpa;

import java.util.List;
import java.util.stream.Collectors;

import org.frusso.travelingdemo.domain.Booking;
import org.frusso.travelingdemo.domain.Flight;
import org.frusso.travelingdemo.repository.BookingRepository;
import org.frusso.travelingdemo.repository.FlightRepository;
import org.frusso.travelingdemo.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("flightService")
@Transactional
public class FlightServiceImpl implements FlightService {

	@Autowired
	private FlightRepository flightRepository;

	@Autowired
	private BookingRepository bookingRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Flight> findAll() {
		return flightRepository.findAll();
	}

	@Override
	public Flight save(Flight flight) {
		return flightRepository.save(flight);
	}

	@Override
	public void delete(Flight flight) {
		flightRepository.delete(flight);
	}

	@Override
	public Flight findFlightByDeparture(String departure) {
		return flightRepository.findByDeparture(departure);
	}

	@Override
	public Flight findFlightByNumber(String number) {
		return flightRepository.findByNumber(number);
	}

	@Override
	public Flight findFlightByDestination(String destination) {
		return flightRepository.findByDestination(destination);
	}

	@Override
	public boolean checkAvailableSeat(String flightNumber, String seat) {
		Flight flight = flightRepository.findByNumber(flightNumber);
		List<Booking> bookings = bookingRepository.findByFlight(flight);
		return !bookings.stream().filter(b -> b.getSeat().equals(seat)).findFirst().isPresent();
	}

	@Override
	public List<String> findBookedSeats(String flightNumber) {
		Flight flight = flightRepository.findByNumber(flightNumber);
		List<Booking> bookings = bookingRepository.findByFlight(flight);
		return bookings.stream().map(b -> b.getSeat()).collect(Collectors.toList());
	}
}
