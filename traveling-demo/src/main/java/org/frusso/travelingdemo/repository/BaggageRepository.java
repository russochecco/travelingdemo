package org.frusso.travelingdemo.repository;

import org.frusso.travelingdemo.domain.Baggage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaggageRepository  extends JpaRepository<Baggage, Long> {

	Baggage findByQuantity(String quantity);
	
	Baggage findByPrice(String price);
	
	Baggage findByType(String type);
	
	Baggage findByQuantityAndType(String quantity, String type);
	
}
