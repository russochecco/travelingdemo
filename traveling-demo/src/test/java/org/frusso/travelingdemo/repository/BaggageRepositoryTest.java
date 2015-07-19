package org.frusso.travelingdemo.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
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
		
		Baggage baggage = new Baggage();
		baggage.setPrice("150");
		baggage.setType("New type");
		baggage.setQuantity("20kg");
		
		baggage = baggageRepository.save(baggage);
		
		Baggage found = baggageRepository.findByQuantityAndType(baggage.getQuantity(), baggage.getType());
		
		assertTrue(baggage.getPrice().equals(found.getPrice()) && baggage.getQuantity().equals(found.getQuantity()));
		
	}
	
	@Test
	public void deleteBaggageTest(){
		
		Baggage found = baggageRepository.findByQuantityAndType("20kg", "Sports Equipment");
		
		assertNotNull(found);
		
		baggageRepository.delete(found);
		
		assertNull(baggageRepository.findByQuantityAndType(found.getQuantity(), found.getType()));
		
	}
	
}
