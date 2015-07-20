package org.frusso.travelingdemo.domain.dto;

import java.time.LocalDate;
import java.util.Optional;

import javax.xml.bind.annotation.XmlRootElement;

import org.frusso.travelingdemo.domain.CreditCard;
import org.frusso.travelingdemo.domain.Guest;
import org.frusso.travelingdemo.domain.Passport;

@XmlRootElement
public class GuestDTO {

	private Long id;
	private String title;
	private String firstName;
	private String lastName;
	private String dateBirth;	
	private PassportDTO passport;
	private CreditCardDTO creditCard;
	
	public GuestDTO(){}
	
	public GuestDTO(Guest guest) {
		
		this.id = guest.getId();
		this.title = guest.getTitle();
		this.firstName = guest.getFirstName();
		this.lastName = guest.getLastName();
		this.dateBirth = guest.getDateBirth().toString();
		
		Optional<Passport> passportPOJO = Optional.of(guest.getPassport());
		if(passportPOJO.isPresent()) {
			this.passport.setNumber(passportPOJO.get().getNumber());
			this.passport.setCountry(passportPOJO.get().getCountry());
			this.passport.setGuestId(passportPOJO.get().getGuest().getId());
			this.passport.setId(passportPOJO.get().getId());
			this.passport.setDateExpire(passportPOJO.get().getDateExpire().toString());
		}
		
		Optional<CreditCard> creditCardPOJO = Optional.of(guest.getCreditCard());
		if(creditCardPOJO.isPresent()) {
			this.creditCard.setNumber(creditCardPOJO.get().getNumber());
			this.creditCard.setCreditCardType(creditCardPOJO.get().getCreditCardType());
			this.creditCard.setGuestId(creditCardPOJO.get().getGuest().getId());
			this.creditCard.setId(creditCardPOJO.get().getId());
			this.creditCard.setDateExpire(creditCardPOJO.get().getDateExpire().toString());
		}
		
	}
	
	public GuestDTO(Long id, String title, String firstName, String lastName, LocalDate dateBirth, PassportDTO passport, CreditCardDTO creditCard) {
		
		this.id = id;
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateBirth = dateBirth.toString();
		this.passport = passport;
		this.creditCard = creditCard;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDateBirth() {
		return dateBirth;
	}

	public void setDateBirth(String dateBirth) {
		this.dateBirth = dateBirth;
	}

	public PassportDTO getPassport() {
		return passport;
	}

	public void setPassport(PassportDTO passport) {
		this.passport = passport;
	}

	public CreditCardDTO getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCardDTO creditCard) {
		this.creditCard = creditCard;
	}

	@Override
	public String toString() {
		return "GuestDTO [id=" + id + ", title=" + title + ", firstName=" + firstName + ", lastName=" + lastName + ", dateBirth=" + dateBirth + ", passport=" + passport + ", creditCard=" + creditCard
				+ "]";
	}
	
}
