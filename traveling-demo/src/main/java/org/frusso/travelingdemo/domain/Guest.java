package org.frusso.travelingdemo.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "guest")
public class Guest implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(nullable = false, name = "title")
	private String title;

	@Column(nullable = false, name = "first_name")
	private String firstName;

	@Column(nullable = false, name = "last_name")
	private String lastName;

	@Column(nullable = false, name = "date_birth")
	@Temporal(TemporalType.DATE)
	private Date dateBirth;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_passport")
	private Passport passport;
	
	@ManyToMany
    @JoinTable(name="guest_baggage", joinColumns=@JoinColumn(name="id_guest"), inverseJoinColumns=@JoinColumn(name="id_baggage"))
	private List<Baggage> baggages;
	
	public Guest() {

	}

	public Guest(String title, String firstName, String lastName, Date dateBirth) {
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateBirth = dateBirth;
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

	public Date getDateBirth() {
		return dateBirth;
	}

	public void setDateBirth(Date dateBirth) {
		this.dateBirth = dateBirth;
	}

}
