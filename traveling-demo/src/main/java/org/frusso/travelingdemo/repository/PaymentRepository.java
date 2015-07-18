package org.frusso.travelingdemo.repository;

import java.util.Date;
import java.util.List;

import org.frusso.travelingdemo.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
	
	List<Payment> findByDatePayment(Date datePayment);
	
}
