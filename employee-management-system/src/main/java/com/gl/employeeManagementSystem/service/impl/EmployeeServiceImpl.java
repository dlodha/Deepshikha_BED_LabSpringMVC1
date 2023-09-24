	package com.gl.employeeManagementSystem.service.impl;
	
	import java.util.List;
	import java.util.Optional;
	
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;
	
	import com.gl.employeeManagementSystem.entity.Employee;
	import com.gl.employeeManagementSystem.repository.EmployeeRepository;
	import com.gl.employeeManagementSystem.service.EmployeeService;
	
	@Service
	public class EmployeeServiceImpl implements EmployeeService {
		
		@Autowired
		private EmployeeRepository employeeRepository;
		
		
	
		public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
			super();
			this.employeeRepository = employeeRepository;
		}
	
		@Override
		public List<Employee> findAllEmployee() {
			// TODO Auto-generated method stub
			return employeeRepository.findAll();
		}
	
		@Override
		public Employee saveEmployee(Employee employee) {
			// TODO Auto-generated method stub
			Employee emp =employeeRepository.save(employee);
			return emp;
		}
	
		@Override
		public Employee findEmployeeById(Long id) {
			// TODO Auto-generated method stub
			Optional<Employee> empOptional= employeeRepository.findById(id);
			if(empOptional.isPresent()) {
				return empOptional.get();
			}
			throw new RuntimeException("Employee doesn't exist");
		}
	
		@Override
		public Employee updateEmployee(Long id ,Employee employee) {
			// TODO Auto-generated method stub
			Employee existingEmp= findEmployeeById(id);
			existingEmp.setFirstName(employee.getFirstName());
			existingEmp.setLastName(employee.getLastName());
			existingEmp.setEmail(employee.getEmail());
			return employeeRepository.save(existingEmp);
		}
	
		@Override
		public void deleteEmployee(Long id) {
			// TODO Auto-generated method stub
			employeeRepository.deleteById(id);
		}
	
		
	}
