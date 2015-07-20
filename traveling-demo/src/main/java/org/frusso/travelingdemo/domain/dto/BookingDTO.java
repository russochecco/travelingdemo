package org.frusso.travelingdemo.domain.dto;

import javax.xml.bind.annotation.XmlRootElement;

import org.frusso.travelingdemo.domain.Booking;

@XmlRootElement
public class BookingDTO {

	private Long id;
	private Long guestId;
	private Long flightId;
	private String dateBooking;
	private String amount;
	private String datePayment;
	private String seat;

	public BookingDTO() {
	}

	public BookingDTO(Booking booking) {

		this.id = booking.getId();
		this.guestId = booking.getGuest().getId();
		this.flightId = booking.getFlight().getId();
		this.dateBooking = booking.getDateBooking().toString();
		this.amount = booking.getAmount();
		this.datePayment = booking.getDatePayment().toString();
		this.seat = booking.getSeat();

	}

	public BookingDTO(Long id, Long guestId, Long flightId, String dateBooking, String amount, String datePayment, String seat) {

		this.id = id;
		this.guestId = guestId;
		this.flightId = flightId;
		this.dateBooking = dateBooking;
		this.amount = amount;
		this.datePayment = datePayment;
		this.seat = seat;

	}

	public Long getBookingId() {
		return id;
	}

	public void setBookingId(Long id) {
		this.id = id;
	}

	public Long getGuestId() {
		return guestId;
	}

	public void setGuestId(Long guestId) {
		this.guestId = guestId;
	}

	public Long getFlightId() {
		return flightId;
	}

	public void setFlightId(Long flightId) {
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
