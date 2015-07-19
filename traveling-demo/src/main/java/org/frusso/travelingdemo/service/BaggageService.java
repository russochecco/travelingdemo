package org.frusso.travelingdemo.service;

import java.util.List;

import org.frusso.travelingdemo.domain.Baggage;

public interface BaggageService {

	List<Baggage> findByQuantity(String quantity);
	
	List<Baggage> allBaggages();

	List<Baggage> findByPrice(String price);
	
	List<Baggage> findByType(String type);
	
	Baggage findByQuantityAndType(String quantity, String type);

	Baggage save(Baggage baggage);

	void delete(Baggage baggage);

}
