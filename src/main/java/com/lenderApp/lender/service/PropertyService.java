package com.lenderApp.lender.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lenderApp.lender.entity.Borrower;
import com.lenderApp.lender.entity.Property;
import com.lenderApp.lender.repository.BorrowerRepository;
import com.lenderApp.lender.repository.PropertyRepository;

@Service
public class PropertyService {
	
	@Autowired
	private PropertyRepository repository;
	
	@Autowired
	private BorrowerRepository borrowerRepository;
	
	public Property addProperty(Long borrowerID, Property entity) {
		Optional<Borrower> optional = borrowerRepository.findById(borrowerID);
		if(optional.isPresent()) {
			entity.setBorrower(optional.get());
			return repository.save(entity);
		}
		throw new RuntimeException("No property found for the given borrower: "+ borrowerID);
	}
	
	public Property getProperty(Long id) {
		return repository.findById(id).orElseThrow(()-> new RuntimeException("Property not found"));
	}
}
