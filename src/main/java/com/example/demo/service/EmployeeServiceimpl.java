package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
@Service
public class EmployeeServiceimpl implements EmployeeService{
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public boolean deleteEmployee(String employeeId) {
		if(employeeRepository.findById(employeeId) != null) {
			employeeRepository.deleteById(employeeId);
			return true;
		}
		else return false;
	}

	@Override
	public boolean addEmployee(Employee employee) {
		try {
			if(!employeeRepository.existsById(employee.getEmployeeId())) {
				employeeRepository.save(employee);
				return true;
			}
			else return false;
		}catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		if(employeeRepository.existsById(employee.getEmployeeId())) {
				try {
					employeeRepository.deleteById(employee.getEmployeeId());
					employeeRepository.save(employee);
					return true;
				}catch (Exception e) {
					return false;
				}
		}
		else return false;
	}

	@Override
	public Employee findEmployee(String employeeId) {
		try {
			if(employeeRepository.existsById(employeeId)) {
				Employee emp = employeeRepository.findById(employeeId).get();
				System.out.println(emp);
				return emp;
			}
			else return null;
		}catch(Exception e) {
			return null;
		}
	}

}
