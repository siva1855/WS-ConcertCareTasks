package com.concertcare.sivatask.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concertcare.sivatask.model.User;
import com.concertcare.sivatask.repository.UserRepository;
import com.concertcare.sivatask.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository UserRepository;

	@Override
	public User saveUser(User user) {
		return UserRepository.save(user);
	}

}
