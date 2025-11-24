package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.employee.Employee;

public interface EmployeeService {
	List<Employee> getAllEmployees();
	Optional<Employee> getEmployee(Integer id);
	void addEmployee(Employee employee);
	void updateEmployee(Employee employee);
	void deleteEmployee(Integer id);
}
