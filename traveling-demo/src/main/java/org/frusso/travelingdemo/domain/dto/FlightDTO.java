package org.frusso.travelingdemo.domain.dto;

import javax.xml.bind.annotation.XmlRootElement;

import org.frusso.travelingdemo.domain.Flight;

@XmlRootElement
public class FlightDTO {

	private String number;
	private String departure;
	private String destination;
	private String date;
	private String timeDeparture;
	private String timeArrival;
	private String status;
	private String price;
	private String type;

	public FlightDTO(Flight flight) {

		this.number = flight.getNumber();
		this.departure = flight.getDeparture();
		this.destination = flight.getDestination();
		this.date = flight.getDate().toString();
		this.timeDeparture = flight.getTimeDeparture().toString();
		this.timeArrival = flight.getTimeArrival().toString();
		this.type = flight.getType();
		this.price = flight.getPrice();
		this.status = flight.getStatus();

	}

	public FlightDTO(String number, String departure, String destination, String date, String timeDeparture, String timeArrival, String status, String price, String type) {

		this.number = number;
		this.departure = departure;
		this.destination = destination;
		this.date = date;
		this.timeDeparture = timeDeparture;
		this.timeArrival = timeArrival;
		this.status = status;
		this.price = price;
		this.type = type;

	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTimeDeparture() {
		return timeDeparture;
	}

	public void setTimeDeparture(String timeDeparture) {
		this.timeDeparture = timeDeparture;
	}

	public String getTimeArrival() {
		return timeArrival;
	}

	public void setTimeArrival(String timeArrival) {
		this.timeArrival = timeArrival;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
