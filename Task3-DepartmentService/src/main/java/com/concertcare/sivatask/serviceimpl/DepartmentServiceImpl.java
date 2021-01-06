package com.concertcare.sivatask.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.concertcare.sivatask.model.Department;
import com.concertcare.sivatask.repository.DepartmentRepository;
import com.concertcare.sivatask.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	private static final Logger logger = LoggerFactory.getLogger(DepartmentServiceImpl.class);

	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public Integer saveDepartment(Department department) {
		logger.info("Inside saveDepartment of DepartmentServiceImpl");
		return departmentRepository.save(department).getDepartmentId();
	}

	@Override
	public List<Department> getAllDepartments() {
		logger.info("Inside getAllDepartments of DepartmentServiceImpl");
		return departmentRepository.findAll();
	}

	@Override
	public Optional<Department> getOneDepartment(Integer departmentId) {
		logger.info("Inside getOneDepartment of DepartmentServiceImpl");
		return departmentRepository.findById(departmentId);
	}

	@Override
	public boolean isExist(Integer departmentId) {
		logger.info("Inside isExist of DepartmentServiceImpl");
		return departmentRepository.existsById(departmentId);
	}

	@Override
	public void deleteDepartment(Integer departmentId) {
		logger.info("Inside deleteDepartment of DepartmentServiceImpl");
		departmentRepository.deleteById(departmentId);
	}

}
