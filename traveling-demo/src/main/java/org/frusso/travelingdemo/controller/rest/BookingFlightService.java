package org.frusso.travelingdemo.controller.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.frusso.travelingdemo.domain.Flight;
import org.frusso.travelingdemo.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

	@GET
	@Path("/find-by-departure")
	@Produces(MediaType.APPLICATION_JSON)
	public Flight findFlightByDeparture(@QueryParam("departure") String departure) {
		return flightService.findByDeparture(departure);
	}
}
