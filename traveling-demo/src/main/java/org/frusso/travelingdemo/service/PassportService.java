package org.frusso.travelingdemo.service;

import java.util.List;

import org.frusso.travelingdemo.domain.Passport;

public interface PassportService {

	List<Passport> findAll();

	Passport findPassportByNumber(String number);

	Passport save(Passport passport);

	void delete(Passport passport);

}
