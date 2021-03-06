package com.example.springboot.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@PutMapping("/employees/{id}")
	public void updateEmployee(@PathVariable long id, @RequestBody Employee employee) {
		
		Employee emp = employeeRepository.getById(id);
		
		emp.setEmailId(employee.getFirstName());
		emp.setFirstName(employee.getFirstName());
		emp.setLastName(employee.getLastName());
		
		employeeRepository.save(emp);
		
	}
	
	@DeleteMapping("/employees/{id}")
	public void deleteEmployee(@PathVariable long id) {
		
		employeeRepository.deleteById(id);
	}
	
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable Long id) {
		
		Optional<Employee> employee = employeeRepository.findById(id);
		
		return ResponseEntity.ok(employee);
	}
	

}
