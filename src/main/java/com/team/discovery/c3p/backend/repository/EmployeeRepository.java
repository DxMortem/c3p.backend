package com.team.discovery.c3p.backend.repository;

import com.team.discovery.c3p.backend.model.c3p.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
