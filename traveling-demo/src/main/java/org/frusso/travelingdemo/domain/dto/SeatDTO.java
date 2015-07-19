package org.frusso.travelingdemo.domain.dto;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class SeatDTO {
	
	private String seat;
	private String status;
	
	@XmlTransient
	private Integer id;
	
	public SeatDTO(Integer id, String seat, String status) {
		
		this.id = id;
		this.seat = seat;
		this.status = status;
		
	}
	
	public SeatDTO(String seat, String status) {
		
		this.seat = seat;
		this.status = status;
		
	}

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
