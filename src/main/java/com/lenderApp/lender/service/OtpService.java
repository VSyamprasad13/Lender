package com.lenderApp.lender.service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Random;

import org.springframework.stereotype.Component;

import com.lenderApp.lender.entity.OtpStore;

@Component
public class OtpService {
	
	public String generateOtp() {
		return String.valueOf(new Random().nextInt(899999)+100000);
	}
	
	public boolean isOtpValid(OtpStore storedOtp, String otp) {
		System.out.println("Otp from the DB: "+storedOtp.getOtp());
		System.out.println("Otp from the postman: "+otp);
		
		if(String.valueOf(storedOtp.getOtp()).equals(otp) && Duration.between(storedOtp.getCreatedAt(), LocalDateTime.now()).toMinutes()<=10) {
			System.out.println("OTP matched");
			return true;
		}
		
		System.out.println("OTP not matched");
		return false;
//		return user.getOtp().equals(otp) &&
//				Duration.between(user.getOtpGeneratedTime(), LocalDateTime.now()).toMinutes() <=5;
	}
}
