package org.frusso.travelingdemo.controller.rest;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.frusso.travelingdemo.controller.rest.errorhandling.CustomWebApplicationException;
import org.frusso.travelingdemo.domain.CreditCard;
import org.frusso.travelingdemo.domain.Flight;
import org.frusso.travelingdemo.domain.Guest;
import org.frusso.travelingdemo.domain.Passport;
import org.frusso.travelingdemo.domain.dto.BaggageDTO;
import org.frusso.travelingdemo.domain.dto.BookingDTO;
import org.frusso.travelingdemo.domain.dto.FlightDTO;
import org.frusso.travelingdemo.domain.dto.GuestDTO;
import org.frusso.travelingdemo.domain.dto.SeatDTO;
import org.frusso.travelingdemo.service.BaggageService;
import org.frusso.travelingdemo.service.BookingService;
import org.frusso.travelingdemo.service.FlightService;
import org.frusso.travelingdemo.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/booking-flight")
public class BookingFlightService {

	@Autowired
	private FlightService flightService;

	@Autowired
	private BaggageService baggageService;

	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private GuestService guestService;
	
	@GET
	@Path("/flight-all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<FlightDTO> findAllFlights() throws CustomWebApplicationException {

		try {
			return flightService.findAll().stream().map(f -> new FlightDTO(f)).collect(Collectors.toList());
		} catch (Exception e) {
			throw new CustomWebApplicationException(e.getMessage());
		}

	}

	@GET
	@Path("/flight-by-departure")
	@Produces(MediaType.APPLICATION_JSON)
	public List<FlightDTO> findFlightsByDeparture(@QueryParam("departure") String departure) throws CustomWebApplicationException {

		try {
			return flightService.findByDeparture(departure).stream().map(f -> new FlightDTO(f)).collect(Collectors.toList());
		} catch (Exception e) {
			throw new CustomWebApplicationException(e.getMessage());
		}

	}

	@POST
	@Path("/flight-add")
	public Response addFlight(FlightDTO flight) throws CustomWebApplicationException {

		try {
			Flight newFlight = new Flight();
			newFlight.setNumber(flight.getNumber());
			newFlight.setPrice(flight.getPrice());
			newFlight.setStatus(flight.getStatus());
			newFlight.setDate(LocalDate.parse(flight.getDate()));
			newFlight.setDeparture(flight.getDeparture());
			newFlight.setDestination(flight.getDestination());
			newFlight.setTimeDeparture(LocalTime.parse(flight.getTimeDeparture()));
			newFlight.setTimeArrival(LocalTime.parse(flight.getTimeArrival()));
			newFlight.setType(flight.getType());
			flightService.save(newFlight);
		} catch (Exception e) {
			throw new CustomWebApplicationException(e.getMessage());
		}

		return Response.status(Status.OK).entity(flight).build();
		
	}

	@GET
	@Path("/flight-by-number")
	@Produces(MediaType.APPLICATION_JSON)
	public FlightDTO findFlightByNumber(@QueryParam("number") String number) throws CustomWebApplicationException {

		try {
			return new FlightDTO(flightService.findByNumber(number));
		} catch (Exception e) {
			throw new CustomWebApplicationException(e.getMessage());
		}

	}

	@GET
	@Path("/flight-baggages-type")
	@Produces(MediaType.APPLICATION_JSON)
	public List<BaggageDTO> flightBaggagesType() throws CustomWebApplicationException {

		try {
			return baggageService.findAll().stream().map(b -> new BaggageDTO(b)).collect(Collectors.toList());
		} catch (Exception e) {
			throw new CustomWebApplicationException(e.getMessage());
		}

	}

	@GET
	@Path("/flight-seats-map")
	@Produces(MediaType.APPLICATION_JSON)
	public List<SeatDTO> flightSeatsMap(@QueryParam("number") String number) throws CustomWebApplicationException {
		
		try {
			return flightService.seatsMap(number).entrySet().stream()
					.map(e -> new SeatDTO(e.getKey(), e.getValue().getSeat(), e.getValue().getSatus()))
					.collect(Collectors.toList());
		} catch (Exception e) {
			throw new CustomWebApplicationException(e.getMessage());
		}

	}

	@GET
	@Path("/flight-check-seat")
	@Produces(MediaType.APPLICATION_JSON)
	public String checkSeat(@QueryParam("number") String number, @QueryParam("seat") String seat) throws CustomWebApplicationException {
		
		try {
			return flightService.checkAvailableSeat(number, seat) ? "available" : "sold-out";
		} catch (Exception e) {
			throw new CustomWebApplicationException(e.getMessage());
		}

	}
	
	@GET
	@Path("/flight-boocked-seats")
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> bookedSeats(@QueryParam("number") String number) throws CustomWebApplicationException {
		
		try {			
			return flightService.findBookedSeats(number);
		} catch (Exception e) {
			throw new CustomWebApplicationException(e.getMessage());
		}

	}
	
	@GET
	@Path("/flight-boockings")
	@Produces(MediaType.APPLICATION_JSON)
	public List<BookingDTO> findFlightBookings(@QueryParam("number") String number) throws CustomWebApplicationException {
		
		try {
			return bookingService.findByFlight(number).stream().map(b-> new BookingDTO(b)).collect(Collectors.toList());
		} catch (Exception e) {
			throw new CustomWebApplicationException(e.getMessage());
		}

	}
	
	@GET
	@Path("/guest-boockings")
	@Produces(MediaType.APPLICATION_JSON)
	public List<BookingDTO> findGuestBookings(@QueryParam("lastName") String lastName, @QueryParam("dateBirth") String dateBirth) throws CustomWebApplicationException {
		
		try {
			return bookingService.findByGuest(lastName, dateBirth).stream().map(b-> new BookingDTO(b)).collect(Collectors.toList());
		} catch (Exception e) {
			throw new CustomWebApplicationException(e.getMessage());
		}

	}
	
	@POST
	@Path("/guest-add")
	public Response addGuest(GuestDTO guest) throws CustomWebApplicationException {

		try {
			Guest newGuest = new Guest();
			newGuest.setLastName(guest.getLastName());
			newGuest.setFirstName(guest.getFirstName());
			newGuest.setTitle(guest.getTitle());
			newGuest.setDateBirth(LocalDate.parse(guest.getDateBirth()));
			
			Passport newPassport = new Passport();
			newPassport.setDateExpire(LocalDate.parse(guest.getPassport().getDateExpire()));
			newPassport.setNumber(guest.getPassport().getNumber());
			newPassport.setCountry(guest.getPassport().getCountry());
			newPassport.setGuest(newGuest);
			newGuest.setPassport(newPassport);

			CreditCard newCreditCard = new CreditCard();
			newCreditCard.setNumber(guest.getCreditCard().getNumber());
			newCreditCard.setCreditCardType(guest.getCreditCard().getCreditCardType());
			newCreditCard.setDateExpire(LocalDate.parse(guest.getCreditCard().getDateExpire()));
			newCreditCard.setNumber(guest.getCreditCard().getNumber());
			newCreditCard.setGuest(newGuest);
			newGuest.setCreditCard(newCreditCard);

			newGuest = guestService.save(newGuest);
			
			guest.setId(newGuest.getId());
			guest.getCreditCard().setId(newCreditCard.getId());
			guest.getPassport().setId(newGuest.getPassport().getId());
		} catch (Exception e) {
			throw new CustomWebApplicationException(e.getMessage());
		}
		
		return Response.status(Status.OK).entity(guest).build();
		
	}
	
}
