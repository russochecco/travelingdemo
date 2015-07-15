package org.frusso.travelingdemo.domain;

public class Baggage {
	
	private Long id;
	private String departing;
	private String returning;
	private String sportEquipmentDeparting;
	private String sportEquipmentReturning;
	
	public Baggage() {
		
	}
	
	public Baggage(String departing, String returning, String sportEquipmentDeparting, String sportEquipmentReturning) {
		super();
		this.departing = departing;
		this.returning = returning;
		this.sportEquipmentDeparting = sportEquipmentDeparting;
		this.sportEquipmentReturning = sportEquipmentReturning;
	}
	
	public String getDeparting() {
		return departing;
	}
	public void setDeparting(String departing) {
		this.departing = departing;
	}
	public String getReturning() {
		return returning;
	}
	public void setReturning(String returning) {
		this.returning = returning;
	}
	public String getSportEquipmentDeparting() {
		return sportEquipmentDeparting;
	}
	public void setSportEquipmentDeparting(String sportEquipmentDeparting) {
		this.sportEquipmentDeparting = sportEquipmentDeparting;
	}
	public String getSportEquipmentReturning() {
		return sportEquipmentReturning;
	}
	public void setSportEquipmentReturning(String sportEquipmentReturning) {
		this.sportEquipmentReturning = sportEquipmentReturning;
	}
	
	
}
