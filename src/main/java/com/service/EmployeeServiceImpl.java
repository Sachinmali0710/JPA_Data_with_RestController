package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.EmployeeDao;
import com.model.Employee;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeDao dao;
	
	@Override
	public Employee addEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return dao.save(emp);
	}

	@Override
	public Employee updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return dao.save(emp);
	}

	@Override
	public Optional<Employee> getEmployee(int empid) {
		// TODO Auto-generated method stub
		return dao.findById(empid);
	}

	@Override
	public String deleteEmployee(int empid) {
		dao.deleteById(empid);
		return "Employee deleted Successfully...";
	}

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> li= dao.findAll();
		// TODO Auto-generated method stub
		return li;
	}

}
