package com.cts.feedbackManagementSystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.feedbackManagementSystem.models.UserModel;
import com.cts.feedbackManagementSystem.services.LoginServices;

@RestController("/login")
public class LoginController {
	
	@Autowired
	LoginServices loginService;
	
	@PostMapping("/check")
	public UserModel login(@RequestBody UserModel user) {
		System.out.println("INside login controller");
		UserModel userModel = loginService.checkUserNameAndPassword(user);
		System.out.println("userModel"+userModel.getName());
		return userModel;
	}
	
	@PostMapping("/checkUserName")
	public boolean checkUserName(@RequestBody UserModel user) {
	  return loginService.checkUserEmailAvailable(user);
	}
	
	@PostMapping("/updatePassword")
	public String updatePassword(@RequestBody UserModel user) {
		return loginService.updatePassword(user);
	}

}
