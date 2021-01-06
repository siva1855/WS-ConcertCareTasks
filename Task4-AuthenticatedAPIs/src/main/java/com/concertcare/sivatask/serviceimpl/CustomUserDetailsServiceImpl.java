package com.concertcare.sivatask.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.concertcare.sivatask.model.User;
import com.concertcare.sivatask.repository.UserRepository;

public class CustomUserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository UserRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = UserRepository.getUserByUserName(username);
		if (user == null) {
			throw new UsernameNotFoundException("Could not find User");
		}
		return new CustomUserDetailsImpl(user);
	}

}
