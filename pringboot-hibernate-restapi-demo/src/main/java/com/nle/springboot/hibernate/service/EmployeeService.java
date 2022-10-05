package com.nle.springboot.hibernate.service;

import java.util.List;

import com.nle.springboot.hibernate.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> findAll();
	
	public Employee findById(String theId);
	
	public void save(Employee theEmployee);
	
	public void deleteById(String theId);

}
