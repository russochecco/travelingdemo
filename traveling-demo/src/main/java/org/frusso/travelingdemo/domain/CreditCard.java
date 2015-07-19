package org.frusso.travelingdemo.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.frusso.travelingdemo.converter.LocalDateConverter;

@Entity
@Table(name = "credit_card")
public class CreditCard implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "credit_card_id")
	private Long id;

	@Column(nullable = false, unique = true, name = "number")
	private String number;

	@Column(nullable = false, name = "credit_card_type")
	private String creditCardType;

	@Column(nullable = false, name = "date_expire")
	@Convert(converter = LocalDateConverter.class)
	private LocalDate dateExpire;

	@MapsId
	@OneToOne(mappedBy = "creditCard")
	@JoinColumn(name = "credit_card_id")
	private Guest guest;

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

	public String getCreditCardType() {
		return creditCardType;
	}

	public void setCreditCardType(String creditCardType) {
		this.creditCardType = creditCardType;
	}

	public LocalDate getDateExpire() {
		return dateExpire;
	}

	public void setDateExpire(LocalDate dateExpire) {
		this.dateExpire = dateExpire;
	}

	public Guest getGuest() {
		return guest;
	}

	public void setGuest(Guest guest) {
		this.guest = guest;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((creditCardType == null) ? 0 : creditCardType.hashCode());
		result = prime * result + ((guest == null) ? 0 : guest.hashCode());
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
		CreditCard other = (CreditCard) obj;
		if (creditCardType == null) {
			if (other.creditCardType != null)
				return false;
		} else if (!creditCardType.equals(other.creditCardType))
			return false;
		if (guest == null) {
			if (other.guest != null)
				return false;
		} else if (!guest.equals(other.guest))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		return true;
	}

}
