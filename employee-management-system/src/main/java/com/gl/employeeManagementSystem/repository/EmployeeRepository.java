package com.gl.employeeManagementSystem.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gl.employeeManagementSystem.entity.Employee;


public interface EmployeeRepository extends JpaRepository<Employee,Long> {

	
	
}