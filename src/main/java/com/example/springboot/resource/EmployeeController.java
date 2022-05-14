package com.example.springboot.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.model.Employee;
import com.example.springboot.repository.EmployeeRepository;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@GetMapping("/employees")
	public List<Employee> getEmployee() {
		
		return employeeRepository.findAll();
		
		//return new Employee("Devangi", "Kacha", "xyz@gmail.com");
	}
	
	
	@PostMapping("/employees")
	public void setEmployee(@RequestBody Employee employee) {
		
		employeeRepository.save(employee);
	}
	

}
