package com.neosoft.EmployeeProcess.repositories;

import com.neosoft.EmployeeProcess.entities.Interviewer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterviewerRepo extends JpaRepository<Interviewer,Long> {
}
