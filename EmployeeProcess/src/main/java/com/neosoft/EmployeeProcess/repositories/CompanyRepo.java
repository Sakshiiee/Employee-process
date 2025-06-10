package com.neosoft.EmployeeProcess.repositories;

import com.neosoft.EmployeeProcess.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepo extends JpaRepository<Company,Long> {
}
