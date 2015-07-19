package org.frusso.travelingdemo.service.jpa;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.frusso.travelingdemo.domain.Flight;
import org.frusso.travelingdemo.domain.Seat;
import org.frusso.travelingdemo.repository.FlightRepository;
import org.frusso.travelingdemo.service.BookingService;
import org.frusso.travelingdemo.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("flightService")
@Transactional
public class FlightServiceImpl implements FlightService {

	@Value("${travelingdemo.seatsmap.columns}")
	private String columns;

	@Value("${travelingdemo.seatsmap.rows}")
	private String rows;

	@Autowired
	private FlightRepository flightRepository;

	@Autowired
	private BookingService bookingService;

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
	public boolean checkAvailableSeat(String number, String seat) {

		Flight flight = flightRepository.findByNumber(number);
		return !bookingService.findByFlight(flight).stream().filter(b -> b.getSeat().equals(seat)).findFirst().isPresent();

	}

	@Override
	public List<String> findBookedSeats(String number) {

		Flight flight = flightRepository.findByNumber(number);
		return bookingService.findByFlight(flight).stream().map(b -> b.getSeat()).collect(Collectors.toList());

	}

	@Override
	public List<Flight> findByDeparture(String departure) {
		return flightRepository.findByDeparture(departure);
	}

	@Override
	public Flight findByNumber(String number) {
		return flightRepository.findByNumber(number);
	}

	@Override
	public List<Flight> findByDestination(String destination) {
		return flightRepository.findByDestination(destination);
	}

	@Override
	public List<Flight> findByDate(LocalDate date) {
		return flightRepository.findByDate(date);
	}

	@Override
	public Map<Integer, Seat> seatsMap(String number) {

		Flight flight = flightRepository.findByNumber(number);
		List<String> soldout = bookingService.findByFlight(flight).stream().map(b -> b.getSeat()).collect(Collectors.toList());
		Map<Integer, Seat> seatsMap = generateFlightSeatsMap(Integer.parseInt(columns), Integer.parseInt(rows));		
		seatsMap.entrySet().stream().forEach(e -> {
			if(soldout.contains(e.getValue().getSeat())){
				e.getValue().setSatus("sold-out");
			}
		});

		return new TreeMap<Integer, Seat>(seatsMap);
		
	}

	private Map<Integer, Seat> generateFlightSeatsMap(int columns, int rows) {

		String column;
		String seat;
		Map<Integer, Seat> seatsMap = new HashMap<Integer, Seat>();
		Integer id = 0;
		for (int i = 0; i < columns; i++) {
			column = Character.toString((char) (i + 65));
			for (int j = 1; j <= rows; j++) {
				seat = column + j;
				id = id + 1;
				seatsMap.put(id, new Seat(id, seat, "available"));
			}
		}

		return seatsMap;
	}
}
