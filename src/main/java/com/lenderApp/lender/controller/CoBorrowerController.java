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

import com.lenderApp.lender.entity.CoBorrower;
import com.lenderApp.lender.service.CoBorrowerService;

@RestController
@RequestMapping("/api/co-borrower")
public class CoBorrowerController {

	@Autowired
	private CoBorrowerService service;
	
	@PostMapping("/{id}")
	public ResponseEntity<CoBorrower> createCoBorrower(@PathVariable Long id,@RequestBody CoBorrower entity){
		CoBorrower coBorrower = service.addCoBorrower(id,entity);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(coBorrower);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CoBorrower> getCoBorrower(@PathVariable Long id){
		CoBorrower entity = service.getCoBorrower(id);
		
		return ResponseEntity.ok(entity);
	}
	
}
