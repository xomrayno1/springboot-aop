package com.tampro.service;

import org.springframework.stereotype.Service;

import com.tampro.model.Employee;

@Service
public class EmployeeService {
	
	public Employee createEmployee(String empId , String firstName , String secondName) {
		Employee employee = new Employee();
		employee.setEmpId(empId);
		employee.setFirstName(firstName);
		employee.setSecondName(secondName);
		return employee;
	}
	public void deleteEmployee(String empId) {
		
	}

}
