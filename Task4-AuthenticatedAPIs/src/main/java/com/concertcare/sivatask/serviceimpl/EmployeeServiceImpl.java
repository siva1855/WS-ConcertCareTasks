package com.concertcare.sivatask.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concertcare.sivatask.model.Employee;
import com.concertcare.sivatask.repository.EmployeeRepository;
import com.concertcare.sivatask.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public void saveEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public Employee getOneEmployee(Integer employeeId) {
		return employeeRepository.findById(employeeId).get();
	}

	@Override
	public void deleteEmployee(Integer employeeId) {
		employeeRepository.deleteById(employeeId);
	}

}
