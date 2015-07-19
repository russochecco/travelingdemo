package org.frusso.travelingdemo.service.jpa;

import java.util.List;

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
	public List<Baggage> findByQuantity(String quantity) {
		return baggageRepository.findByQuantity(quantity);
	}

	@Override
	public List<Baggage> findByPrice(String price) {
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
	public List<Baggage> findByType(String type) {
		return baggageRepository.findByType(type);
	}

	@Override
	public List<Baggage> allBaggages() {
		return baggageRepository.findAll();
	}

	@Override
	public Baggage findByQuantityAndType(String quantity, String type) {
		return baggageRepository.findByQuantityAndType(quantity, type);
	}

}
