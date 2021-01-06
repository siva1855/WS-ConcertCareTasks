package com.concertcare.sivatask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.concertcare.sivatask.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
