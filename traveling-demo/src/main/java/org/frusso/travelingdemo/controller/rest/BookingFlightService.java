package org.frusso.travelingdemo.controller.rest;

import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.frusso.travelingdemo.controller.rest.errorhandling.CustomWebApplicationException;
import org.frusso.travelingdemo.domain.Flight;
import org.frusso.travelingdemo.domain.Guest;
import org.frusso.travelingdemo.domain.dto.BaggageDTO;
import org.frusso.travelingdemo.domain.dto.BookingDTO;
import org.frusso.travelingdemo.domain.dto.FlightDTO;
import org.frusso.travelingdemo.domain.dto.SeatDTO;
import org.frusso.travelingdemo.service.BaggageService;
import org.frusso.travelingdemo.service.BookingService;
import org.frusso.travelingdemo.service.FlightService;
import org.frusso.travelingdemo.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

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
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addFlight(@FormParam("flight") String flight) throws CustomWebApplicationException {

		try {
			ObjectMapper mapper = new ObjectMapper();
			Flight newFlight = mapper.readValue(flight, Flight.class);
			flightService.save(newFlight);
		} catch (Exception e) {
			throw new CustomWebApplicationException(e.getMessage());
		}

		return Response.status(Status.OK).build();
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
	public List<BookingDTO> findGuestBookings(@QueryParam("last-name") String lastName, @QueryParam("date-birth") String dateBirth) throws CustomWebApplicationException {
		
		try {
			return bookingService.findByGuest(lastName, dateBirth).stream().map(b-> new BookingDTO(b)).collect(Collectors.toList());
		} catch (Exception e) {
			throw new CustomWebApplicationException(e.getMessage());
		}

	}
	
	@POST
	@Path("/guest-add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addGuest(@QueryParam("guest") String guest, @QueryParam("passport") String passport, @QueryParam("credit-card") String creditCard) throws CustomWebApplicationException {

		try {
			ObjectMapper mapper = new ObjectMapper();
			Guest newGuest = mapper.readValue(guest, Guest.class);
			
			
			
//			guestService.save(newGuest);
		} catch (Exception e) {
			throw new CustomWebApplicationException(e.getMessage());
		}

		return Response.status(Status.OK).build();
		
	}
	
}
