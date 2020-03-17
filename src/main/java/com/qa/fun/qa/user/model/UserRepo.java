package com.qa.fun.qa.user.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
	
	User findByUserName(String userName);
	
}
