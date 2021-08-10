package com.example.demo.service;

import com.example.demo.model.Employee;

public interface EmployeeService {
	
	public boolean deleteEmployee(String employeeId);
	public boolean addEmployee(Employee employee);
	public boolean updateEmployee(Employee employee);
	public Employee findEmployee(String employeeId);

}
