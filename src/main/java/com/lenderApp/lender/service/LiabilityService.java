package com.lenderApp.lender.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lenderApp.lender.entity.Borrower;
import com.lenderApp.lender.entity.Liabilities;
import com.lenderApp.lender.repository.BorrowerRepository;
import com.lenderApp.lender.repository.LiabilityRepository;

@Service
public class LiabilityService {
	
	@Autowired
	private LiabilityRepository repository;
	
	@Autowired
	private BorrowerRepository borrowerRepository;
	
	public Liabilities addLiability(Long borrowerID,Liabilities entity) {
		Optional<Borrower> optional = borrowerRepository.findById(borrowerID);
		if(optional.isPresent()) {
			entity.setBorrower(optional.get());
			return repository.save(entity);
		}
		throw new RuntimeException("No property found for the given borrower: "+ borrowerID);
	}
	
	public Liabilities getLiabilityDetails(Long id) {
		return repository.findById(id).orElseThrow(()->new RuntimeException("No liability details for the provided id: "+id));
	}
}
