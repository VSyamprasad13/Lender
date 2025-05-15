package com.lenderApp.lender.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lenderApp.lender.entity.Liabilities;
import com.lenderApp.lender.service.LiabilityService;

@RestController
@RequestMapping("/api/liability")
public class LiabilityController {
	
	@Autowired
	private LiabilityService service;
	
	@PostMapping("/{id}")
	public ResponseEntity<Liabilities> saveLiabilityDetails(@PathVariable Long id, @RequestBody Liabilities entity){
		Liabilities liability = service.addLiability(id, entity);
		return ResponseEntity.status(HttpStatus.CREATED).body(liability);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Liabilities> getLiabilityDetails(@PathVariable Long id){
		Liabilities details = service.getLiabilityDetails(id);
		return ResponseEntity.ok(details);
	}
}
