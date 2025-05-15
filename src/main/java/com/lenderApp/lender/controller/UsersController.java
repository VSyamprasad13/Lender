package com.lenderApp.lender.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lenderApp.lender.entity.Users;
import com.lenderApp.lender.service.UsersService;

@RestController
@RequestMapping("/api/users")
public class UsersController {
	
	@Autowired
	private UsersService service;
	
	@PostMapping("{borrowerId}")
	public ResponseEntity<Users> createUser(@PathVariable Long borrowerId){
		Users newUser = service.createUser(borrowerId);
		
		return ResponseEntity.ok(newUser);
	}
	
	@GetMapping("{userID}")
	public ResponseEntity<Users> getUser(@PathVariable Long userID){
		Users user = service.getUserByUserID(userID);
		return ResponseEntity.ok(user);
	}
	
	@GetMapping
	public ResponseEntity<List<Users>> getUsers(){
		List<Users> users = service.getAllUsers();
		return ResponseEntity.ok(users);
	}
}
