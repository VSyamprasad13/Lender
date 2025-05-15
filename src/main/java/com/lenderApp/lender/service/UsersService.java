package com.lenderApp.lender.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lenderApp.lender.entity.Borrower;
import com.lenderApp.lender.entity.Users;
import com.lenderApp.lender.repository.BorrowerRepository;
import com.lenderApp.lender.repository.UsersRepository;

@Service
public class UsersService {
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private BorrowerRepository borrowerRepository;
	
	public Users createUser(Long borrowerId) {
		Optional<Borrower> borrowerOptional = borrowerRepository.findById(borrowerId);
		if(borrowerOptional.isEmpty()) {
			throw new RuntimeException("Borrower not found");
		}
		
		Borrower borrower = borrowerOptional.get();
		
		if(usersRepository.findByUserID(borrower.getMobilenumber()).isPresent()) {
			throw new RuntimeException("User already exists");
		}
		Users user = new Users(borrower.getMobilenumber(),borrower.getFullName(),borrower);
		
		return usersRepository.save(user);
	}
	
	public Users getUserByUserID(Long id) {
		return usersRepository.findByUserID(id).orElseThrow(() -> new RuntimeException("User not found"));
	}
	
	public List<Users> getAllUsers(){
		return usersRepository.findAll();
	}
	
}
