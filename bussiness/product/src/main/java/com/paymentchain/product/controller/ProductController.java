package com.paymentchain.product.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.paymentchain.product.entities.Product;
import com.paymentchain.product.repository.ProductRepository;



/**
 *
 * @author sotobotero
 */
@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductRepository productRepository;


	@GetMapping
	public List<Product> get() {
		return productRepository.findAll();
	}

	@GetMapping("/{id}")
	public Product get(@PathVariable long id) {
		Product product = productRepository.findById(id).get();
		return product;
	}

	
	
	@PutMapping("/{productId}")
	public ResponseEntity<?> put(@PathVariable String id, @RequestBody Product input) {
		return null;
	}

	

	 

	@DeleteMapping("/{productId}")
	public ResponseEntity<?> delete(@PathVariable String id) {
		return null;
	}
	
	 @PostMapping
	    public ResponseEntity<?> post(@RequestBody Product input) {       
	        Product save = productRepository.save(input);
	        return ResponseEntity.ok(save);
	    }

}
