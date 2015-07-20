package org.frusso.travelingdemo.domain.dto;

import javax.xml.bind.annotation.XmlRootElement;

import org.frusso.travelingdemo.domain.CreditCard;

@XmlRootElement
public class CreditCardDTO {

	private Long id;
	private Long guestId;
	private String number;
	private String creditCardType;
	private String dateExpire;

	public CreditCardDTO() {
	}

	public CreditCardDTO(CreditCard creditCard) {

		this.id = creditCard.getId();
		this.number = creditCard.getNumber();
		this.creditCardType = creditCard.getCreditCardType();
		this.dateExpire = creditCard.getDateExpire().toString();
		this.guestId = creditCard.getId();

	}

	public CreditCardDTO(Long id, String number, String creditCardType, String dateExpire, Long guestId) {

		this.id = id;
		this.number = number;
		this.creditCardType = creditCardType;
		this.dateExpire = dateExpire;
		this.guestId = guestId;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getGuestId() {
		return guestId;
	}

	public void setGuestId(Long guestId) {
		this.guestId = guestId;
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

	public String getDateExpire() {
		return dateExpire;
	}

	public void setDateExpire(String dateExpire) {
		this.dateExpire = dateExpire;
	}

	@Override
	public String toString() {
		return "CreditCardDTO [id=" + id + ", guestId=" + guestId + ", number=" + number + ", creditCardType=" + creditCardType + ", dateExpire=" + dateExpire + "]";
	}

}
