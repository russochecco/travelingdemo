package org.frusso.travelingdemo.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "guest_baggage")
public class GuestBaggage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@JsonIgnore
	@ManyToOne(fetch=FetchType.EAGER) 
	@JoinColumn(name = "id_guest")
	private Guest guest;

	@JsonIgnore
	@ManyToOne(fetch=FetchType.EAGER) 
	@JoinColumn(name = "id_baggage")
	private Baggage baggage;
	
	
}
