package com.paymentchain.transactions.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.paymentchain.transactions.entities.Transaction;
import com.paymentchain.transactions.repository.TransactionRepository;

@RestController
@RequestMapping("/transaction")
public class TransactionsController {
	@Autowired
	TransactionRepository transactionRepository;

	@GetMapping()
	public List<Transaction> list() {
		return transactionRepository.findAll();
	}

	@PostMapping
	public ResponseEntity<?> post(@RequestBody Transaction input) {

		Transaction save = transactionRepository.save(input);
		return ResponseEntity.ok(save);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Transaction> get(@PathVariable long id) {
		return transactionRepository.findById(id).map(x -> ResponseEntity.ok(x))
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/transactions")
	public List<Transaction> get(@RequestParam String ibanAccount) {
		return transactionRepository.findByIbanAccount(ibanAccount);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> put(@PathVariable String id, @RequestBody Transaction input) {
		return null;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable String id) {
		return null;
	}
}
