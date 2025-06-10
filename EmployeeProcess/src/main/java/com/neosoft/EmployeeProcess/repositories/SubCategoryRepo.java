package com.neosoft.EmployeeProcess.repositories;

import com.neosoft.EmployeeProcess.entities.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubCategoryRepo extends JpaRepository<SubCategory,Long> {
}
