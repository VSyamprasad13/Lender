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

import com.lenderApp.lender.entity.Property;
import com.lenderApp.lender.service.PropertyService;

@RestController
@RequestMapping("/api/property")
public class PropertyController {

	@Autowired
	private PropertyService service;
	
	@PostMapping("/{id}")
	public ResponseEntity<Property> saveProperty(@PathVariable Long id,@RequestBody Property entity){
		Property property = service.addProperty(id,entity);
		return ResponseEntity.status(HttpStatus.CREATED).body(property);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Property> getPropertyDetails(@PathVariable Long id){
		Property property = service.getProperty(id);
		System.out.println(property);
		return ResponseEntity.ok(property);
	}
}
