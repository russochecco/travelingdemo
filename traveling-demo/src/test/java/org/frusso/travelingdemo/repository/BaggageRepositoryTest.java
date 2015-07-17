package org.frusso.travelingdemo.repository;

import static org.junit.Assert.assertTrue;

import org.frusso.travelingdemo.TravelingDemoApplication;
import org.frusso.travelingdemo.domain.Baggage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TravelingDemoApplication.class)
public class BaggageRepositoryTest {

	@Autowired
	private BaggageRepository baggageRepository;
	
	@Test
	public void addNewBaggageTest() {
		
		Baggage newBaggage = new Baggage();
		newBaggage.setPrice("HKD 150");
		newBaggage.setType("New type");
		newBaggage.setQuantity("20kg");
		baggageRepository.save(newBaggage);
		
		Baggage found = baggageRepository.findByType(newBaggage.getType());
		assertTrue(newBaggage.getPrice().equals(found.getPrice()) && newBaggage.getQuantity().equals(found.getQuantity()));
	}
	
}
