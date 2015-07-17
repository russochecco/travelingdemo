package org.frusso.travelingdemo.service.jpa;

import org.frusso.travelingdemo.domain.Baggage;
import org.frusso.travelingdemo.repository.BaggageRepository;
import org.frusso.travelingdemo.service.BaggageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("baggageService")
@Transactional
public class BaggageServiceImpl implements BaggageService {

	@Autowired
	private BaggageRepository baggageRepository;

	@Override
	public Baggage findBaggageByQuantity(String quantity) {
		return baggageRepository.findByQuantity(quantity);
	}

	@Override
	public Baggage findBaggageByPrice(String price) {
		return baggageRepository.findByPrice(price);
	}

	@Override
	public Baggage save(Baggage baggage) {
		return baggageRepository.save(baggage);
	}

	@Override
	public void delete(Baggage baggage) {
		baggageRepository.delete(baggage);
	}

	@Override
	public Baggage findBaggageByType(String type) {
		return baggageRepository.findByType(type);
	}

}
