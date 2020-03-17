package com.qa.fun.qa.user.service;

import com.qa.fun.qa.user.model.User;
import com.qa.fun.qa.user.model.UserDetailsImpl;
import com.qa.fun.qa.user.model.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Qualifier("dbUserDetails")
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
		User user = userRepo.findByUserName(s);
		return new UserDetailsImpl(user);
	}
}
