package com.cts.feedbackManagementSystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.feedbackManagementSystem.models.UserModel;
import com.cts.feedbackManagementSystem.services.SignUpServices;

@RestController
public class SignUpController {
	
	@Autowired
	SignUpServices signUpServices;
	
	@GetMapping("/")
	public String welcome() {
		System.out.println("Entered");
		return "Welcome";
	}
	
	@PostMapping("/newUser")
	public String saveNewUser(@RequestBody UserModel signUpModel) {
		System.out.println("Entered sign Up controller");
		return signUpServices.saveNewUser(signUpModel);
	}

}
