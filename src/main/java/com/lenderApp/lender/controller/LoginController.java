package com.lenderApp.lender.controller;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lenderApp.lender.entity.OtpStore;
import com.lenderApp.lender.entity.Token;
import com.lenderApp.lender.entity.Users;
import com.lenderApp.lender.jwt.JwtUtility;
import com.lenderApp.lender.repository.OtpStoreRepository;
import com.lenderApp.lender.repository.TokenRepository;
import com.lenderApp.lender.repository.UsersRepository;
import com.lenderApp.lender.service.OtpService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/auth")
public class LoginController {
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private JwtUtility jwtUtility;
	
	@Autowired
	private OtpService otpService;
	
	@Autowired
	private OtpStoreRepository otpStoreRepository;
	
	@Autowired
	private TokenRepository tokenRepository;
	
	@GetMapping("/token")
	public CsrfToken getCSRFToken(HttpServletRequest request) {
		return (CsrfToken) request.getAttribute("_csrf");
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestParam Long mobile) {
        String otp = otpService.generateOtp();
        
        Optional<OtpStore> optionalStore = otpStoreRepository.findByMobile(mobile);
        OtpStore store;
        if(optionalStore.isEmpty()) {
        	store=new OtpStore();
        	store.setMobile(mobile);
        }else {
        	store=optionalStore.get();
        }
        store.setOtp(otp);
        store.setCreatedAt(LocalDateTime.now());
        otpStoreRepository.save(store);
        	
        return ResponseEntity.ok("Generated OTP: "+otp);
    }
	
	@PostMapping("/verify")
	public ResponseEntity<?> verify(@RequestParam Long mobile, @RequestParam String otp) {
	    Optional<OtpStore> store = otpStoreRepository.findByMobile(mobile);

	    if (store.isPresent() && otpService.isOtpValid(store.get(), otp)) {
	        // Fetch user or assign default role
	        String role = "ROLE_USER"; // Default
	        Optional<Users> optionalUser = usersRepository.findByUserID(mobile);
	        if (optionalUser.isPresent()) {
	            role = optionalUser.get().getRole(); // e.g., "ROLE_USER" or "ROLE_ADMIN"
	        }

	        // Generate JWT with role
	        String jwtToken = jwtUtility.generateToken(mobile, role);

	        // Save token to DB
	        Token token = new Token();
	        token.setMobile(mobile);
	        token.setCreatedAt(LocalDateTime.now());
	        token.setExpiresAt(token.getCreatedAt().plusHours(48));
	        token.setTokenValue(jwtToken);
	        tokenRepository.save(token);

	        return ResponseEntity.ok("Token: " + jwtToken);
	    }

	    return ResponseEntity.badRequest().body("Invalid OTP or MSISDN");
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/admin/secure-data")
	public ResponseEntity<String> getAdminData() {
	    return ResponseEntity.ok("Confidential Admin Data");
	}

	@PreAuthorize("hasRole('USER')")
	@GetMapping("/user/profile")
	public ResponseEntity<String> getUserProfile() {
	    return ResponseEntity.ok("User Profile Data");
	}
	
	
}
