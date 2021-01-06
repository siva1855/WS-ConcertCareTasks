package com.concertcare.sivatask.service;

import java.util.List;

import com.concertcare.sivatask.model.Employee;

public interface EmployeeService {

	public List<Employee> getAllEmployees();

	public void saveEmployee(Employee employee);

	public Employee getOneEmployee(Integer employeeId);

	public void deleteEmployee(Integer employeeId);
}
