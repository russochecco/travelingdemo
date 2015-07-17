package org.frusso.travelingdemo.service.jpa;

import java.util.List;

import org.frusso.travelingdemo.domain.Passport;
import org.frusso.travelingdemo.repository.PassportRepository;
import org.frusso.travelingdemo.service.PassportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("passportService")
@Transactional
public class PassportServiceImpl implements PassportService {

	@Autowired
	private PassportRepository passportRepository;

	@Override
	public List<Passport> findAll() {
		return passportRepository.findAll();
	}

	@Override
	public Passport findPassportByNumber(String number) {
		return passportRepository.findByNumber(number);
	}

	@Override
	public Passport save(Passport passport) {
		return passportRepository.save(passport);
	}

	@Override
	public void delete(Passport passport) {
		passportRepository.save(passport);
	}

}
