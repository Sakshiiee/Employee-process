package com.neosoft.EmployeeProcess.repositories;


import com.neosoft.EmployeeProcess.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {

}
