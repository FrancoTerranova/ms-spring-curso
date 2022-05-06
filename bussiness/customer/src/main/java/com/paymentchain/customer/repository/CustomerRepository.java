package com.paymentchain.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.paymentchain.customer.entities.Customer;

/**
 *
 * @author sotobotero
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	@Query("SELECT c FROM Customer c WHERE c.code = :code")
	public Customer findByCode(@Param("code") String code);
}