package com.itp.ITPfirstSpringboot.controller;

//package com.itp.ITPfirstSpringboot.controller;

import com.itp.ITPfirstSpringboot.entity.*;
import com.itp.ITPfirstSpringboot.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private SalaryRepository salaryRepository;

    @PostMapping("/departments")
    public Department createDepartment(@RequestBody Department department) {
        return departmentRepository.save(department);
    }

    @PostMapping("/departments/{deptId}/employees")
    public Employee createEmployee(@PathVariable Long deptId, @RequestBody Employee employee) {
        Department dept = departmentRepository.findById(deptId).orElseThrow();
        employee.setDepartment(dept);
        return employeeRepository.save(employee);
    }

    @GetMapping("/employees/designation/{designation}")
    public List<Employee> getEmployeesByDesignation(@PathVariable Designation designation) {
        return employeeRepository.findByDesignation(designation);
    }

    @GetMapping("/employees/salary")
    public List<Employee> getEmployeesBySalaryRange(@RequestParam Double min, @RequestParam Double max) {
        return employeeRepository.findBySalaryBetween(min, max);
    }

    @GetMapping("/employees/page")
    public Page<Employee> getEmployeesByPage(@RequestParam int page, @RequestParam int size) {
        return employeeRepository.findAll(PageRequest.of(page, size));
    }

    @GetMapping("/departments/{deptId}/employees")
    public List<Employee> getEmployeesByDepartment(@PathVariable Long deptId) {
        return employeeRepository.findByDepartmentId(deptId);
    }
}
