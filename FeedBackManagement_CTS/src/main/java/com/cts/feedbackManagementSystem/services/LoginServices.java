package com.cts.feedbackManagementSystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.feedbackManagementSystem.models.UserModel;
import com.cts.feedbackManagementSystem.repo.LoginRepo;

@Service
public class LoginServices {
	
	@Autowired
	LoginRepo loginRepo;
	
	public UserModel checkUserNameAndPassword(UserModel user) {
		System.out.println("Inside login service "+user.getName());
		UserModel userModel = loginRepo.findByName(user.getName());
		System.out.println("user"+userModel);
		if((userModel != null) && (userModel.getPassword() == user.getPassword())) {
			return userModel;
		}
		return null;
	}
	
	public boolean checkUserEmailAvailable(UserModel user) {
	  boolean checkEmailExist = loginRepo.findByEmail(user.getEmail());
	  return checkEmailExist;
	}
	
	public String updatePassword(UserModel user) {
		boolean updatePasswordStatus = loginRepo.updatePasswordByEmail(user.getEmail(), user.getPassword());
		return updatePasswordStatus ? "Password updated Successfully" : "Password is not Updated";
	}

}
