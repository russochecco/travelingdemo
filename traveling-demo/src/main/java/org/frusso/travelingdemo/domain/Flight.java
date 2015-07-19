package org.frusso.travelingdemo.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.frusso.travelingdemo.converter.LocalDateConverter;
import org.frusso.travelingdemo.converter.LocalTimeConverter;

@Entity
@Table(name = "flight")
public class Flight implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "flight_id")
	private Long id;

	@Column(nullable = false, unique = true, name = "number")
	private String number;

	@Column(nullable = false, name = "departure")
	private String departure;

	@Column(nullable = false, name = "destination")
	private String destination;

	@Column(nullable = false, name = "date_flight")
	@Convert(converter = LocalDateConverter.class)
	private LocalDate date;

	@Column(nullable = false, name = "time_departure")
	@Convert(converter = LocalTimeConverter.class)
	private LocalTime timeDeparture;

	@Column(nullable = false, name = "time_arrival")
	@Convert(converter = LocalTimeConverter.class)
	private LocalTime timeArrival;

	@Column(nullable = false, name = "status")
	private String status;

	@Column(nullable = false, name = "price")
	private String price;

	@Column(nullable = false, name = "flight_type")
	private String type;

	@OneToMany(mappedBy = "flight", fetch = FetchType.EAGER)
	private List<Booking> bookings;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTimeDeparture() {
		return timeDeparture;
	}

	public void setTimeDeparture(LocalTime timeDeparture) {
		this.timeDeparture = timeDeparture;
	}

	public LocalTime getTimeArrival() {
		return timeArrival;
	}

	public void setTimeArrival(LocalTime timeArrival) {
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

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flight other = (Flight) obj;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Flight [id=" + id + ", number=" + number + ", departure=" + departure + ", destination=" + destination + ", date=" + date + ", timeDeparture=" + timeDeparture + ", timeArrival="
				+ timeArrival + ", status=" + status + ", price=" + price + ", type=" + type + "]";
	}

}
