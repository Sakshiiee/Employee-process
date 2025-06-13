package com.neosoft.EmployeeProcess.Services.ServiceImpl;

import com.neosoft.EmployeeProcess.Services.DepartmentService;
import com.neosoft.EmployeeProcess.dtos.DepartmentDto;
import com.neosoft.EmployeeProcess.dtos.PageableResponse;
import com.neosoft.EmployeeProcess.entities.Company;
import com.neosoft.EmployeeProcess.entities.Department;
import com.neosoft.EmployeeProcess.exceptions.ResourceNotFoundException;
import com.neosoft.EmployeeProcess.helper.Helper;
import com.neosoft.EmployeeProcess.repositories.CompanyRepo;
import com.neosoft.EmployeeProcess.repositories.DepartmentRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepo departmentRepo;

    @Autowired
    private CompanyRepo companyRepo;

    @Autowired
    private ModelMapper modelMapper;

    // Create
    @Override
    public DepartmentDto createDepartment(DepartmentDto dto) {
        Company company = companyRepo.findById(dto.getCompanyId())
                .orElseThrow(() -> new ResourceNotFoundException("Company not found with ID: " + dto.getCompanyId()));

        Department department = modelMapper.map(dto, Department.class);
        department.setCompany(company);

        Department saved = departmentRepo.save(department);
        return modelMapper.map(saved, DepartmentDto.class);
    }

    // Update
    @Override
    public DepartmentDto updateDepartment(DepartmentDto dto, Long departmentId) {
        Department department = departmentRepo.findById(departmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found with ID: " + departmentId));

        department.setName(dto.getName());
        department.setDescription(dto.getDescription());

        if (dto.getCompanyId() != null) {
            Company company = companyRepo.findById(dto.getCompanyId())
                    .orElseThrow(() -> new ResourceNotFoundException("Company not found with ID: " + dto.getCompanyId()));
            department.setCompany(company);
        }

        Department updated = departmentRepo.save(department);
        return modelMapper.map(updated, DepartmentDto.class);
    }

    // Delete
    @Override
    public void deleteDepartment(Long departmentId) {
        Department department = departmentRepo.findById(departmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found with ID: " + departmentId));
        departmentRepo.delete(department);
    }

    // Get all departments with pagination
    @Override
    public PageableResponse<DepartmentDto> getAllDepartments(int pageNumber, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase("desc") ?
                Sort.by(sortBy).descending() :
                Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        Page<Department> page = departmentRepo.findAll(pageable);
        return Helper.getPageableResponse(page, DepartmentDto.class);
    }
    @Override
    public DepartmentDto getDepartmentById(Long departmentId) {
        Department department = departmentRepo.findById(departmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found with ID: " + departmentId));
        return modelMapper.map(department, DepartmentDto.class);
    }


    // Search by keyword
    @Override
    public List<DepartmentDto> searchDepartment(String keyword) {
        List<Department> departments = departmentRepo.findByNameContainingIgnoreCase(keyword);
        return departments.stream()
                .map(dept -> modelMapper.map(dept, DepartmentDto.class))
                .collect(Collectors.toList());
    }
}
