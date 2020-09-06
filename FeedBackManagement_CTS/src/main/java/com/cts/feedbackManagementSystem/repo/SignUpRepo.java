package com.cts.feedbackManagementSystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.feedbackManagementSystem.models.UserModel;

@Repository
public interface SignUpRepo extends JpaRepository<UserModel, Integer> {
	
	public boolean existsByEmail(String email);

}
