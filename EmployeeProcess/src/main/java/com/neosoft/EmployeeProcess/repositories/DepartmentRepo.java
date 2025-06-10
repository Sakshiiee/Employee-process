package com.neosoft.EmployeeProcess.repositories;

import com.neosoft.EmployeeProcess.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends JpaRepository<Department,Long> {
}
