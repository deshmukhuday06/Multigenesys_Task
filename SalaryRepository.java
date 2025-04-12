package com.itp.ITPfirstSpringboot.repository;

import com.itp.ITPfirstSpringboot.entity.Salary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryRepository extends JpaRepository<Salary, Long> {
}
