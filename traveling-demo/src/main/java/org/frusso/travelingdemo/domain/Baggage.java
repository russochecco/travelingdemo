package org.frusso.travelingdemo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Baggage")
public class Baggage {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(nullable = false, name = "quantity")
	private String quantity;

	@Column(nullable = false, name = "type_baggage")
	private String type;

	@Column(nullable = false, name = "price")
	private String price;

	public Baggage() {

	}

	public Baggage(String quantity, String type, String price) {
		this.quantity = quantity;
		this.type = type;
		this.price = price;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

}
