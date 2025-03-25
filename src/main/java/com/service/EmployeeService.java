package com.service;

import java.util.List;
import java.util.Optional;

import com.model.Employee;

public interface EmployeeService {
	
	Employee addEmployee(Employee emp);
	
	Employee updateEmployee(Employee emp);
	
	Optional<Employee> getEmployee(int empid);
	
	String deleteEmployee(int empid);
	
	List<Employee> getAllEmployee();
	
}
