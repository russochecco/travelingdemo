package org.frusso.travelingdemo.domain.dto;

import javax.xml.bind.annotation.XmlRootElement;

import org.frusso.travelingdemo.domain.Booking;

@XmlRootElement
public class BookingDTO {

	private String id;
	private String guestId;
	private String flightId;
	private String dateBooking;
	private String amount;
	private String datePayment;
	private String seat;

	public BookingDTO() {
	}

	public BookingDTO(Booking booking) {

		this.id = booking.getId().toString();
		this.guestId = booking.getGuest().getId().toString();
		this.flightId = booking.getFlight().getId().toString();
		this.dateBooking = booking.getDateBooking().toString();
		this.amount = booking.getAmount();
		this.datePayment = booking.getDatePayment().toString();
		this.seat = booking.getSeat();

	}

	public BookingDTO(String id, String guestId, String flightId, String dateBooking, String amount, String datePayment, String seat) {

		this.id = id;
		this.guestId = guestId;
		this.flightId = flightId;
		this.dateBooking = dateBooking;
		this.amount = amount;
		this.datePayment = datePayment;
		this.seat = seat;

	}

	public String getBookingId() {
		return id;
	}

	public void setBookingId(String id) {
		this.id = id;
	}

	public String getGuestId() {
		return guestId;
	}

	public void setGuestId(String guestId) {
		this.guestId = guestId;
	}

	public String getFlightId() {
		return flightId;
	}

	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}

	public String getDateBooking() {
		return dateBooking;
	}

	public void setDateBooking(String dateBooking) {
		this.dateBooking = dateBooking;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getDatePayment() {
		return datePayment;
	}

	public void setDatePayment(String datePayment) {
		this.datePayment = datePayment;
	}

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}

	@Override
	public String toString() {
		return "BookingDTO [id=" + id + ", guestId=" + guestId + ", flightId=" + flightId + ", dateBooking=" + dateBooking + ", amount=" + amount + ", datePayment=" + datePayment
				+ ", seat=" + seat + "]";
	}

}
