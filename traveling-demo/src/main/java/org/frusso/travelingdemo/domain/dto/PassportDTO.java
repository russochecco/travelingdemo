package org.frusso.travelingdemo.domain.dto;

import javax.xml.bind.annotation.XmlRootElement;

import org.frusso.travelingdemo.domain.Passport;

@XmlRootElement
public class PassportDTO {

	private Long id;
	private Long guestId;
	private String number;
	private String country;
	private String dateExpire;

	public PassportDTO() {
	}

	public PassportDTO(Passport passport) {

		this.id = passport.getId();
		this.number = passport.getNumber();
		this.country = passport.getCountry();
		this.dateExpire = passport.getDateExpire().toString();
		this.guestId = passport.getId();

	}

	public PassportDTO(Long id, Long guestId, String number, String country, String dateExpire) {
		this.id = id;
		this.guestId = guestId;
		this.number = number;
		this.country = country;
		this.dateExpire = dateExpire;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDateExpire() {
		return dateExpire;
	}

	public void setDateExpire(String dateExpire) {
		this.dateExpire = dateExpire;
	}

	@Override
	public String toString() {
		return "PassportDTO [id=" + id + ", guestId=" + guestId + ", number=" + number + ", country=" + country + ", dateExpire=" + dateExpire + "]";
	}

}
