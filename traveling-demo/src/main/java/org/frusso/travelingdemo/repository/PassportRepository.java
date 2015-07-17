package org.frusso.travelingdemo.repository;

import org.frusso.travelingdemo.domain.Passport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassportRepository extends JpaRepository<Passport, Long> {
	
	Passport findByNumber(String number);

}
