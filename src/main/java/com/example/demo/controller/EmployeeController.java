package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.demo.employee.Employee;
import com.example.demo.service.EmpService;


@Controller
public class EmployeeController {

	@Autowired
	EmpService empService;
	
	@GetMapping("/employees")
	public String  getAllEmployees(Model model){
		List<Employee> myList = empService.getAllEmployees();
		model.addAttribute("employees",myList);
		return "list-emps";
	}
	
	@GetMapping("/addEmployee")
	public String addEmployee(Model model) {
		model.addAttribute("employee",new Employee());
		return "employee-form";
	}
	@GetMapping("updateEmployee")
	public String updateEmployee(@RequestParam("Id") int id, Model model) {
		model.addAttribute("employee",empService.getEmployee(id));
		return "employee-form";
	}
	@GetMapping("deleteEmployee")
	public String deleteEmployee(@RequestParam("Id") int id, Model model) {
		empService.deleteEmployee(id);
		return "redirect:/employees";

	}
	
	@PostMapping("/save")
	public String saveStudent(@ModelAttribute("employee") Employee employee) {
		empService.addEmployee(employee);
		return "redirect:/employees";
	}
	}
 
	
