package com.tampro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tampro.model.Employee;
import com.tampro.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping(value = "/add/employee")
	public Employee addEmployee(@RequestParam("empId") String empId,
			@RequestParam("firstName") String firstName,
			@RequestParam("secondName") String secondName) {
		
		return employeeService.createEmployee(empId, firstName, secondName);
	}
	
	@GetMapping(value = "/remove/employee")
	public String removeEmployee(@RequestParam("empId") String empId) {
		
		employeeService.deleteEmployee(empId);
		return "remove employee";
	}
}
