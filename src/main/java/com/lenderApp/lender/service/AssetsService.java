package com.lenderApp.lender.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lenderApp.lender.entity.Assets;
import com.lenderApp.lender.entity.Borrower;
import com.lenderApp.lender.repository.AssetsRepository;
import com.lenderApp.lender.repository.BorrowerRepository;

@Service
public class AssetsService {
	
	@Autowired
	private AssetsRepository repository;
	
	@Autowired
	private BorrowerRepository borrowerRepository;
	
	public Assets addAssets(Long borrowerID,Assets entity) {
		Optional<Borrower> optional = borrowerRepository.findById(borrowerID);
		if(optional.isPresent()) {
			entity.setBorrower(optional.get());
			return repository.save(entity);
		}
		throw new RuntimeException("No property found for the given borrower: "+ borrowerID);
	}
	
	public Assets getAssetDetails(Long id) {
		return repository.findById(id).orElseThrow(()->new RuntimeException("Asset not found"));
	}

}
