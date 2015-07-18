package org.frusso.travelingdemo.service;

import java.util.List;

import org.frusso.travelingdemo.domain.Baggage;

public interface BaggageService {

	Baggage findByQuantity(String quantity);
	
	List<Baggage> allBaggages();

	Baggage findByPrice(String price);
	
	Baggage findByType(String type);

	Baggage save(Baggage baggage);

	void delete(Baggage baggage);

}
