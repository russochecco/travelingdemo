package org.frusso.travelingdemo.service;

import org.frusso.travelingdemo.domain.Baggage;

public interface BaggageService {

	Baggage findBaggageByQuantity(String quantity);

	Baggage findBaggageByPrice(String price);
	
	Baggage findBaggageByType(String type);

	Baggage save(Baggage baggage);

	void delete(Baggage baggage);

}
