package com.concertcare.sivatask.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concertcare.sivatask.feignclient.UserFeignClient;
import com.concertcare.sivatask.model.User;
import com.concertcare.sivatask.repository.UserRepository;
import com.concertcare.sivatask.service.UserService;
import com.concertcare.sivatask.template.UserDepartmentResponseTemplate;
import com.concertcare.sivatask.vo.DepartmentVO;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserFeignClient userFeignClient;

	@Override
	public Integer saveUser(User user) {
		logger.info("Inside saveUser of UserServiceImpl");
		return userRepository.save(user).getUserId();
	}

	@Override
	public List<User> getAllUsers() {
		logger.info("Inside getAllUsers of UserServiceImpl");
		return userRepository.findAll();
	}

	@Override
	public Optional<User> getOneUser(Integer userId) {
		logger.info("Inside getOneUser of UserServiceImpl");
		return userRepository.findById(userId);
	}

	@Override
	public boolean isExist(Integer userId) {
		logger.info("Inside isExist of UserServiceImpl");
		return userRepository.existsById(userId);
	}

	@Override
	public void deleteUser(Integer userId) {
		logger.info("Inside deleteUser of UserServiceImpl");
		userRepository.deleteById(userId);
	}

	@Override
	public UserDepartmentResponseTemplate getUserWithDepartment(Integer userId) {
		logger.info("Inside getUserWithDepartment of UserServiceImpl");
		UserDepartmentResponseTemplate userDepartmentResponseTemplate = new UserDepartmentResponseTemplate();
		User user = userRepository.findByUserId(userId);
		DepartmentVO departmentVO = userFeignClient.getUserDept(user.getDepartmentId());
		userDepartmentResponseTemplate.setUser(user);
		userDepartmentResponseTemplate.setDepartmentVO(departmentVO);
		return userDepartmentResponseTemplate;
	}

}
