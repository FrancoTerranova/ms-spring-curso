package com.paymentchain.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.paymentchain.product.entities.Product;

/**
 *
 * @author sotobotero
 */
public interface ProductRepository extends JpaRepository<Product, Long> {

	
}