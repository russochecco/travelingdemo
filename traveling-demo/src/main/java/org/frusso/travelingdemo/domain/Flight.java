package org.frusso.travelingdemo.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Flight")
public class Flight implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(nullable = false, unique = true, name ="number")
	private String number;

	@Column(nullable = false, name = "departure")
	private String departure;

	@Column(nullable = false, name = "destination")
	private String destination;

	@Column(nullable = false, name="date_flight")
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@Column(nullable = false, name = "time_departure")
	@Temporal(TemporalType.TIME)
	private Date timeDeparture;
	
	@Column(nullable = false, name = "time_arrival")
	@Temporal(TemporalType.TIME)
	private Date timeArrival;

	@Column(nullable = false, name ="status")
	private String status;

	@Column(nullable = false,  name = "price")
	private String price;

	@Column(nullable = false, name ="type_flight")
	private String type;

	public Flight(){
		
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public Date getTimeDeparture() {
		return timeDeparture;
	}

	public void setTimeDeparture(Date timeDeparture) {
		this.timeDeparture = timeDeparture;
	}

	public Date getTimeArrival() {
		return timeArrival;
	}

	public void setTimeArrival(Date timeArrival) {
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
		return "Flight [number=" + number + ", departure=" + departure + ", destination=" + destination + ", date=" + date + ", timeDeparture=" + timeDeparture + ", timeArrival=" + timeArrival
				+ ", status=" + status + ", price=" + price + ", type=" + type + "]";
	}
	
}
