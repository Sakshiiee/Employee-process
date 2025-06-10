package com.neosoft.EmployeeProcess.repositories;

import com.neosoft.EmployeeProcess.entities.InterviewBatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterviewBatchRepo extends JpaRepository<InterviewBatch,Long> {
}
