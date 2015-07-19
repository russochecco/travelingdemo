package org.frusso.travelingdemo.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.frusso.travelingdemo.converter.LocalDateConverter;

@Entity
@Table(name = "booking")
public class Booking implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "booking_id")
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "guest_id")
	private Guest guest;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "flight_id")
	private Flight flight;

	@Column(nullable = false, name = "date_booking")
	@Convert(converter = LocalDateConverter.class)
	private LocalDate dateBooking;

	@Column(nullable = true, name = "amount_payment")
	private String amount;

	@Column(nullable = false, name = "date_payment")
	@Convert(converter = LocalDateConverter.class)
	private LocalDate datePayment;

	@Column(nullable = false, name = "seat")
	private String seat;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Guest getGuest() {
		return guest;
	}

	public void setGuest(Guest guest) {
		this.guest = guest;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public LocalDate getDateBooking() {
		return dateBooking;
	}

	public void setDateBooking(LocalDate dateBooking) {
		this.dateBooking = dateBooking;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public LocalDate getDatePayment() {
		return datePayment;
	}

	public void setDatePayment(LocalDate datePayment) {
		this.datePayment = datePayment;
	}

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateBooking == null) ? 0 : dateBooking.hashCode());
		result = prime * result + ((flight == null) ? 0 : flight.hashCode());
		result = prime * result + ((guest == null) ? 0 : guest.hashCode());
		result = prime * result + ((seat == null) ? 0 : seat.hashCode());
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
		Booking other = (Booking) obj;
		if (dateBooking == null) {
			if (other.dateBooking != null)
				return false;
		} else if (!dateBooking.equals(other.dateBooking))
			return false;
		if (flight == null) {
			if (other.flight != null)
				return false;
		} else if (!flight.equals(other.flight))
			return false;
		if (guest == null) {
			if (other.guest != null)
				return false;
		} else if (!guest.equals(other.guest))
			return false;
		if (seat == null) {
			if (other.seat != null)
				return false;
		} else if (!seat.equals(other.seat))
			return false;
		return true;
	}

}
