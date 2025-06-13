package com.neosoft.EmployeeProcess.Services;

import com.neosoft.EmployeeProcess.dtos.DepartmentDto;
import com.neosoft.EmployeeProcess.dtos.PageableResponse;


import java.util.List;

public interface DepartmentService {

    DepartmentDto createDepartment(DepartmentDto dto);

    DepartmentDto updateDepartment(DepartmentDto dto, Long departmentId);

    void deleteDepartment(Long departmentId);

    DepartmentDto getDepartmentById(Long departmentId);

    PageableResponse<DepartmentDto> getAllDepartments(int pageNumber, int pageSize, String sortBy, String sortDir);

    List<DepartmentDto> searchDepartment(String keyword);
}
