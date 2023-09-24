package com.gl.employeeManagementSystem.service;

import java.util.List;

import com.gl.employeeManagementSystem.entity.Employee;

public interface EmployeeService {
  public List<Employee> findAllEmployee();
  public Employee saveEmployee(Employee emp);
  public Employee findEmployeeById(Long id);
  public Employee updateEmployee(Long id,Employee emp);
  public void deleteEmployee(Long id);
}
