package org.frusso.travelingdemo.repository;

import java.util.List;

import org.frusso.travelingdemo.domain.Baggage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaggageRepository  extends JpaRepository<Baggage, Long> {

	List<Baggage> findByQuantity(String quantity);
	
	List<Baggage> findByPrice(String price);
	
	List<Baggage> findByType(String type);
	
	Baggage findByQuantityAndType(String quantity, String type);
	
}
