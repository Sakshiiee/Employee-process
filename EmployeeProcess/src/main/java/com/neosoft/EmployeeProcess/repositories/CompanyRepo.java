package com.neosoft.EmployeeProcess.repositories;

import com.neosoft.EmployeeProcess.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyRepo extends JpaRepository<Company, Long> {

    Optional<Company> findByEmail(String email);

    List<Company> findByNameContaining(String keywords);
}
