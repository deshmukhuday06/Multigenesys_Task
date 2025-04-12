package com.itp.ITPfirstSpringboot.repository;

import com.itp.ITPfirstSpringboot.entity.Designation;
import com.itp.ITPfirstSpringboot.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByDesignation(Designation designation);

    @Query("SELECT e FROM Employee e JOIN e.salary s WHERE s.amount BETWEEN :min AND :max")
    List<Employee> findBySalaryBetween(Double min, Double max);

    Page<Employee> findAll(Pageable pageable);

    List<Employee> findByDepartmentId(Long departmentId);
}
