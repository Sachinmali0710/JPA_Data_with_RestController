package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.model.Employee;
import com.service.EmployeeService;

@RestController
@RequestMapping("/emp") 		//http://localhost:9331/emp/add
public class EmployeeController {

	
	@Autowired
	EmployeeService service;
	
	@PostMapping("/add")
	public String addEmployee(@RequestBody List<Employee> emps)
	{
		for(Employee employee : emps)
		{
			service.addEmployee(employee);
			System.out.println("Adding Employee: "+employee.getEmpname());
		}
		return "Employee added Successfully...";
	}
	
	@PutMapping("/update")
	public String updateEmployee(@RequestBody Employee emp)
	{
		service.updateEmployee(emp);
		System.out.println("Updated Successfully .."+emp.getEmpid());
		return "Employee Updated Successfully...";	
	}
	
	@GetMapping("/get/{id}")
	public void getEmployeeById(@PathVariable("id") int empid)
	{
		service.getEmployee(empid);
		System.out.println(service.getEmployee(empid));
	}
	
	@GetMapping("/getall")
	public List<Employee> getAllEmployee()
	{
		List<Employee> li= service.getAllEmployee();
		return li;
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteEmp(@PathVariable("id") int empid)
	{
		 Optional<Employee> emp= service.getEmployee(empid);
		 if (emp.isPresent()) {			
			 String str = service.deleteEmployee(empid);
			 System.out.println(str);			 
		}
		 else
		 {
			 System.out.println("Employee not found...");
		 }
	}
}
