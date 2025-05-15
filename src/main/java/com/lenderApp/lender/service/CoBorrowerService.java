package com.lenderApp.lender.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lenderApp.lender.dto.CoBorrowerDTO;
import com.lenderApp.lender.entity.Borrower;
import com.lenderApp.lender.entity.CoBorrower;
import com.lenderApp.lender.repository.BorrowerRepository;
import com.lenderApp.lender.repository.CoBorrowerRepository;

@Service
public class CoBorrowerService {
	
	private static final Logger logger = LoggerFactory.getLogger(BorrowerService.class);
	
	@Autowired
	private CoBorrowerRepository repository;
	
	@Autowired
	private BorrowerRepository borrowerRepository;
	
	public CoBorrower addCoBorrower(Long borrowerId,CoBorrower entity) {
		Optional<Borrower> optional = borrowerRepository.findById(borrowerId);
		if(optional.isPresent()) {
			entity.setBorrower(optional.get());
			return repository.save(entity);
		}
		throw new RuntimeException("Borrower not found with the provided ID: "+ borrowerId);
	}
	
	public CoBorrower getCoBorrower(Long id) {
		return repository.findById(id).orElseThrow(()-> new RuntimeException("CoBorrower not found"));
	}
	
	public Optional<CoBorrower> updateCoBorrower(Long id, CoBorrowerDTO dto){
		logger.info("Received request to update borrower with ID: "+id);
			
		return repository.findById(id).map(coBorrower ->{
			if(dto.getFirstName()!=null) coBorrower.setfirstName(dto.getFirstName());
			if(dto.getLastName()!=null) coBorrower.setlastName(dto.getLastName());
			if(dto.getMobileNumber()!=null) coBorrower.setmobileNumber(dto.getMobileNumber());
			if(dto.getAddress()!=null) coBorrower.setAddress(dto.getAddress());
			if(dto.getCity()!=null) coBorrower.setCity(dto.getCity());
			if(dto.getState()!=null) coBorrower.setState(dto.getState());
			if(dto.getCountry()!=null) coBorrower.setCountry(dto.getCountry());
			if(dto.getEmploymentStatus()!=null) coBorrower.setEmployment_status(dto.getEmploymentStatus());
			if(dto.getEmployerName()!=null) coBorrower.setEmployer_name(dto.getEmployerName());
			
			CoBorrower coBorrower2 = repository.save(coBorrower);
			return coBorrower2;
		});
	}
}
