package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.employee.Employee;
import com.example.demo.service.EmpService;

@Controller
public class EmployeeController {

    @Autowired
    EmpService empService;

    // Anyone logged in can view employee list
    @GetMapping("/employees")
    @PreAuthorize("hasAnyRole('EMPLOYEE', 'MANAGER', 'ADMIN')")
    public String getAllEmployees(Model model) {
        List<Employee> myList = empService.getAllEmployees();
        model.addAttribute("employees", myList);
        return "list-emps";
    }

    // Anyone (EMPLOYEE, MANAGER, ADMIN) can view a single employee
    @GetMapping("/employee")
    @PreAuthorize("hasAnyRole('EMPLOYEE', 'MANAGER', 'ADMIN')")
    public String getEmployeeById(@RequestParam("id") int id, Model model) {
        model.addAttribute("employee", empService.getEmployee(id));
        return "employee-form";
    }
  
    // Only MANAGER or ADMIN can add employees
    @GetMapping("/addEmployee")
    @PreAuthorize("hasAnyRole('MANAGER', 'ADMIN')")
    public String addEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee-form";
    }

    // Only MANAGER or ADMIN can update employees
    @GetMapping("/updateEmployee")
    @PreAuthorize("hasAnyRole('MANAGER', 'ADMIN')")
    public String updateEmployee(@RequestParam("Id") int id, Model model) {
        model.addAttribute("employee", empService.getEmployee(id));
        return "employee-form";
    }

    // Only MANAGER or ADMIN can save employees
    @PostMapping("/save")
    @PreAuthorize("hasAnyRole('MANAGER', 'ADMIN')")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        empService.addEmployee(employee);
        return "redirect:/employees";
    }

    // Only ADMIN can delete employees
    @GetMapping("/deleteEmployee")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteEmployee(@RequestParam("Id") int id) {
        empService.deleteEmployee(id);
        return "redirect:/employees";
    }
}
