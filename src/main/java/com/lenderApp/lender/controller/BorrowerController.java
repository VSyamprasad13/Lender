package com.lenderApp.lender.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lenderApp.lender.dto.BorrowerDTO;
import com.lenderApp.lender.entity.Borrower;
import com.lenderApp.lender.service.BorrowerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/borrowers")
public class BorrowerController {
	
	private static final Logger logger = LoggerFactory.getLogger(BorrowerController.class);
	
	@Autowired
	private BorrowerService borrowerService;
	
	@PostMapping
	public ResponseEntity<Borrower> createBorrower(@RequestBody Borrower borrower){
		Borrower saveBorrower = borrowerService.saveBorrower(borrower);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(saveBorrower);
	}
	
//	public ResponseEntity<BorrowerEntity> getBorrowers(){
//		return ResponseEntity.
//	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Borrower> getBorrower(@PathVariable Long id){
		Optional<Borrower> borrower = borrowerService.getBorrower(id);
		
		return ResponseEntity.ok(borrower.get());
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<Borrower> updateBorrower(@PathVariable Long id, @Valid @RequestBody BorrowerDTO dto){
		logger.info("Processing update request for borrower ID: {}",id);
		
		Optional<Borrower> borrower = borrowerService.updateBorrower(id, dto);
		
		return borrower.map(ResponseEntity::ok).orElseGet(() -> {
			logger.warn("Borrower with ID {} not found.",id);
			return ResponseEntity.notFound().build();
		});
	}

}
