package org.frusso.travelingdemo.domain;

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
@Table(name = "passport")
public class Passport {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(nullable = false, unique = true, name = "number")
	private String number;

	@Column(nullable = false, name = "country")
	private String country;

	@Column(nullable = false, name = "date_expire")
	@Temporal(TemporalType.DATE)
	private Date dateExpire;

	public Passport() {
	}

	public Passport(String number, String country, Date dateExpire) {
		this.number = number;
		this.country = country;
		this.dateExpire = dateExpire;
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

	public Date getDateExpire() {
		return dateExpire;
	}

	public void setDateExpire(Date dateExpire) {
		this.dateExpire = dateExpire;
	}

}
