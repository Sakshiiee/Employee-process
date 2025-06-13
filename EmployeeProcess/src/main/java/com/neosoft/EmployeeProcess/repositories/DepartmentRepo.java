package com.neosoft.EmployeeProcess.repositories;

import com.neosoft.EmployeeProcess.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepo extends JpaRepository<Department, Long> {
    List<Department> findByNameContainingIgnoreCase(String keyword);
}
