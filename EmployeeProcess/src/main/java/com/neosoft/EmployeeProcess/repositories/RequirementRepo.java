package com.neosoft.EmployeeProcess.repositories;

import com.neosoft.EmployeeProcess.entities.Requirement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequirementRepo extends JpaRepository<Requirement,Long> {
}
