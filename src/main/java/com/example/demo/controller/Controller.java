package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.employee.Employee;
import com.example.demo.service.EmpService;

@RestController
public class Controller {

	@Autowired
	EmpService empService;
	
	@GetMapping("/employees")
	public List<Employee>  getAllEmployees(){
		return empService.getAllEmployees();
	}
	
	@GetMapping("/employees/{id}")
	public Optional<Employee> getEmployee(@PathVariable Integer id) {
		return empService.getEmployee(id);
	}
	@PostMapping("/employees")
	public String addEmployee(@RequestBody Employee emp) {
		empService.addEmployee(emp);
		return emp + "\nAdded Successfully";
	}
	@PutMapping("/employees")
	public String updateEmployee(@RequestBody Employee emp) {
		empService.updateEmployee(emp);
		return emp + "\nUpdated Successfully";
	}
	@DeleteMapping("/employees/{id}")
	public String deleteEmployee(@PathVariable Integer id) {
		empService.deleteEmployee(id);
		return "Deleted Successfully";
	}
}
