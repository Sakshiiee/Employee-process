package com.neosoft.EmployeeProcess.repositories;

import com.neosoft.EmployeeProcess.entities.CandidateCV;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateCVRepo extends JpaRepository<CandidateCV, Long> {

}
