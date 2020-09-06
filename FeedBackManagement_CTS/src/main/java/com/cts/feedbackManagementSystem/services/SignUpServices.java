package com.cts.feedbackManagementSystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.feedbackManagementSystem.models.UserModel;
import com.cts.feedbackManagementSystem.repo.SignUpRepo;

@Service
public class SignUpServices {
	
	@Autowired
	SignUpRepo signUpRepo;
	
	
	public String saveNewUser(UserModel signUpModel) {
		String email = signUpModel.getEmail();
		boolean isEmailExist = signUpRepo.existsByEmail(email);
		if(isEmailExist) {
			return "User Alerady Eist";
		}
		else {
			signUpModel.setRole("user_Role");
			signUpRepo.save(signUpModel);
			return "New User Saved Successfully";
		}
	}

}
