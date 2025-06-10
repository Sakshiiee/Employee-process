package com.neosoft.EmployeeProcess.repositories;

import com.neosoft.EmployeeProcess.entities.Criteria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CriteriaRepo extends JpaRepository<Criteria,Long> {
}
