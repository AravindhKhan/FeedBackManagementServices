package com.cts.feedbackManagementSystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.feedbackManagementSystem.models.UserModel;

@Repository
public interface LoginRepo extends JpaRepository<UserModel, Integer> {
	
	UserModel findByName(String name);
	
	boolean findByEmail(String email);
	
	boolean updatePasswordByEmail(String email,String password);

}
