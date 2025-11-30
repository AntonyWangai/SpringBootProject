package com.example.demo.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.employee.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
