package com.neosoft.EmployeeProcess.repositories;

import com.neosoft.EmployeeProcess.entities.Screening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScreeningRepo extends JpaRepository<Screening, Long> {
}
