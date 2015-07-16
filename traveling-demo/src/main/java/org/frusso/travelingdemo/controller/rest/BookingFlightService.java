package org.frusso.travelingdemo.controller.rest;

import java.util.List;

import javax.ws.rs.Consumes;
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
import org.frusso.travelingdemo.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
@Path("/booking-flight")
public class BookingFlightService {

	@Autowired
	private FlightService flightService;

	@GET
	@Path("/all-flights")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Flight> allFlights() {
		return flightService.findAll();
	}

	@POST
	@Path("/add-flight")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addFlight(@QueryParam("flight") String jsonFlightRepresentation) throws CustomWebApplicationException {
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			Flight newFlight = mapper.readValue(jsonFlightRepresentation, Flight.class);
			flightService.save(newFlight);
		} catch (Exception e) {
			String message = e.getMessage();
			throw new CustomWebApplicationException(message);
		}
		
		return Response.status(Status.OK).build();
	}

	@GET
	@Path("/find-by-departure")
	@Produces(MediaType.APPLICATION_JSON)
	public Flight findFlightByDeparture(@QueryParam("departure") String departure) {
		return flightService.findByDeparture(departure);
	}

}
