package com.gl.employeeManagementSystem.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.gl.employeeManagementSystem.entity.Employee;
import com.gl.employeeManagementSystem.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService; 
	
	
    public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}


	@GetMapping("/employees")
     public String getEmployee(Model model) {
		List<Employee> employees =employeeService.findAllEmployee();
		model.addAttribute("employees", employees);
		return "employees";
	}
	@GetMapping("/employees/new")
    public String createEmployee(Model model) {
		Employee employee =new Employee();
		model.addAttribute("employee", employee);
		return "create_employee";
	}
	
	@PostMapping("/employees")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.saveEmployee(employee);
	    return "redirect:/employees";
	}
	
	@GetMapping("/employees/edit/{id}")
	 public String updateEmployeeForm(@PathVariable Long id,  Model model) {
	  model.addAttribute("employee",employeeService.findEmployeeById(id));
	  return "edit_employee";
	 }
	@PostMapping("/employees/{id}")
    public String updateEmployee(@PathVariable Long id, @ModelAttribute("employee") Employee employee) {
		employeeService.updateEmployee(id, employee);
	    return "redirect:/employees";
	}
	
	@GetMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable Long id) {
		employeeService.deleteEmployee(id);
	    return "redirect:/employees";
	}
	

}
