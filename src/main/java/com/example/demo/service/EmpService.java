package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.employee.Employee;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmpService implements EmployeeService {
	@Autowired
	private EmployeeRepository emp;
	
	@Override
	public List<Employee> getAllEmployees() {
		
		return emp.findAll();
		}

	@Override
	public Optional<Employee> getEmployee(Integer id) {
		return emp.findById(id);
	}

	@Override
	public void addEmployee(Employee employee) {
		emp.save(employee);
	}

	@Override
	public void updateEmployee(Employee employee) {
		emp.save(employee);

	}

	@Override
	public void deleteEmployee(Integer id) {
		emp.deleteById(id);

	}

}
