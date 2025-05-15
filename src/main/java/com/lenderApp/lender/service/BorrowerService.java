package com.lenderApp.lender.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lenderApp.lender.dto.BorrowerDTO;
import com.lenderApp.lender.entity.Borrower;
import com.lenderApp.lender.entity.Users;
import com.lenderApp.lender.repository.BorrowerRepository;
import com.lenderApp.lender.repository.UsersRepository;

import jakarta.transaction.Transactional;


@Service
public class BorrowerService {
	
	private static final Logger logger = LoggerFactory.getLogger(BorrowerService.class);
	
	@Autowired
	private BorrowerRepository borrowerRepository;
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Transactional
	public Borrower saveBorrower(Borrower borrower) {
		
		Borrower savedBorrower = borrowerRepository.save(borrower);
		
		Users users = new Users();
		
		users.setBorrower(savedBorrower);
		users.setUserID(savedBorrower.getMobilenumber());
		users.setBorrowerName(savedBorrower.getFullName());
		
		usersRepository.save(users);
		
		return savedBorrower;
	}
	
	public Optional<Borrower> getBorrower(Long id) {
		return borrowerRepository.findById(id);
//		return borrowerRepository.findById(id).orElseThrow(() -> new RuntimeException("Borrower not found"));
	}
	
	public Optional<Borrower> updateBorrower(Long id, BorrowerDTO dto){
		logger.info("Received request to update borrower with ID: "+id);
		
		return borrowerRepository.findById(id).map(borrower ->{
			if(dto.getfirstName() != null) {
				logger.debug("Updating first name for borrower ID: {}",id);
				borrower.setFirstname(dto.getfirstName());
			}
			if(dto.getlastName() != null) {
				logger.debug("Updating last name for borrower ID: {}",id);
				borrower.setLastname(dto.getlastName());
			}
			if(dto.getmobileNumber()!=null) {
				logger.debug("Updating mobile number for borrowed ID: {}",id);
				borrower.setMobilenumber(dto.getmobileNumber());
			}
			if(dto.getAddress()!=null) {
				logger.debug("Updating address");
				borrower.setAddress(dto.getAddress());
			}
			if(dto.getCity()!=null) borrower.setCity(dto.getCity());
			if(dto.getState()!=null) borrower.setState(dto.getState());
			if(dto.getZipcode()!=null) borrower.setZipcode(dto.getZipcode());
			if(dto.getCountry()!=null) borrower.setCountry(dto.getCountry());
			if(dto.getEmploymentStatus()!=null) borrower.setEmploymentstatus(dto.getEmploymentStatus());
			if(dto.getEmployerName()!=null) borrower.setEmployername(dto.getEmployerName());
			if(dto.getyearsOfExperience() != 0) borrower.setYearsofexperience(dto.getyearsOfExperience());
			if(dto.getcreditScore()!=0) borrower.setCreditscore(dto.getcreditScore());
			Borrower entity = borrowerRepository.save(borrower);
			logger.info("Successfully updated borrower details with ID: {}",id);
			return entity;
		});
	}
}
