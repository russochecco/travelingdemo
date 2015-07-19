package org.frusso.travelingdemo.domain.dto;

import javax.xml.bind.annotation.XmlRootElement;

import org.frusso.travelingdemo.domain.Baggage;

@XmlRootElement
public class BaggageDTO {
	
	private String quantity;
	private String type;
	private String price;
	
	public BaggageDTO(Baggage baggage) {
		
		this.quantity = baggage.getQuantity();
		this.type = baggage.getType();
		this.price = baggage.getType();
		
	}
	
	public BaggageDTO(String quantity, String type, String price) {
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
