package org.frusso.travelingdemo.repository;

import org.frusso.travelingdemo.domain.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
	
	CreditCard findByNumber(String number);
}
