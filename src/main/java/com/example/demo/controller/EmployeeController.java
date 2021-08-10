package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/api/emp")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("register")
	public ResponseEntity<String> registerEmployee(@RequestBody Employee employee) {
		boolean bool = employeeService.addEmployee(employee);
		if(bool) {
			return new ResponseEntity<String>("ok", HttpStatus.CREATED);
		}
		else return new ResponseEntity<String>("no", HttpStatus.CONFLICT);

	}
	
	
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<String> delEmployee(@PathVariable("id") String employeeId){
		if(employeeService.deleteEmployee(employeeId)) {
			return new ResponseEntity<String>("ok", HttpStatus.OK);
		}
		else return new ResponseEntity<String>("no", HttpStatus.NOT_FOUND);

	}
	
	@PutMapping("update")
	public ResponseEntity<String> update(@RequestBody Employee employee){
		if(employeeService.updateEmployee(employee)) {
			return new ResponseEntity<String>("ok", HttpStatus.OK);
		}
		else return new ResponseEntity<String>("no", HttpStatus.NOT_FOUND);
	}
	
	
	@GetMapping("/employee/{id}")
	public Employee findEmployee(@PathVariable("id") String employeeId) {
		    return employeeService.findEmployee(employeeId);
	}

}
