package com.concertcare.sivatask.service;

import java.util.List;
import java.util.Optional;

import com.concertcare.sivatask.model.Department;

public interface DepartmentService {

	public Integer saveDepartment(Department department);

	public List<Department> getAllDepartments();

	public Optional<Department> getOneDepartment(Integer departmentId);

	public boolean isExist(Integer departmentId);

	public void deleteDepartment(Integer departmentId);
}
