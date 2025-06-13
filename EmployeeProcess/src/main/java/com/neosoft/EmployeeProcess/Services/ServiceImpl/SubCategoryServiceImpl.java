package com.neosoft.EmployeeProcess.Services.ServiceImpl;

import com.neosoft.EmployeeProcess.Services.SubCategoryService;
import com.neosoft.EmployeeProcess.dtos.PageableResponse;
import com.neosoft.EmployeeProcess.dtos.SubCategoryDto;
import com.neosoft.EmployeeProcess.entities.Department;
import com.neosoft.EmployeeProcess.entities.SubCategory;
import com.neosoft.EmployeeProcess.exceptions.ResourceNotFoundException;
import com.neosoft.EmployeeProcess.helper.Helper;
import com.neosoft.EmployeeProcess.repositories.DepartmentRepo;
import com.neosoft.EmployeeProcess.repositories.SubCategoryRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubCategoryServiceImpl implements SubCategoryService {

    @Autowired
    private SubCategoryRepo subCategoryRepo;

    @Autowired
    private DepartmentRepo departmentRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public SubCategoryDto createSubCategory(SubCategoryDto subCategoryDto) {
        Department department = departmentRepo.findById(subCategoryDto.getDepartmentId())
                .orElseThrow(() -> new ResourceNotFoundException("Department", "ID", subCategoryDto.getDepartmentId()));

        SubCategory subCategory = modelMapper.map(subCategoryDto, SubCategory.class);
        subCategory.setDepartment(department);

        SubCategory saved = subCategoryRepo.save(subCategory);
        return modelMapper.map(saved, SubCategoryDto.class);
    }

    @Override
    public SubCategoryDto updateSubCategory(SubCategoryDto subCategoryDto, Long subCategoryId) {
        SubCategory existing = subCategoryRepo.findById(subCategoryId)
                .orElseThrow(() -> new ResourceNotFoundException("SubCategory", "ID", subCategoryId));

        Department department = departmentRepo.findById(subCategoryDto.getDepartmentId())
                .orElseThrow(() -> new ResourceNotFoundException("Department", "ID", subCategoryDto.getDepartmentId()));

        existing.setName(subCategoryDto.getName());
        existing.setDescription(subCategoryDto.getDescription());
        existing.setDepartment(department);

        SubCategory updated = subCategoryRepo.save(existing);
        return modelMapper.map(updated, SubCategoryDto.class);
    }

    @Override
    public void deleteSubCategory(Long subCategoryId) {
        SubCategory subCategory = subCategoryRepo.findById(subCategoryId)
                .orElseThrow(() -> new ResourceNotFoundException("SubCategory", "ID", subCategoryId));
        subCategoryRepo.delete(subCategory);
    }

    @Override
    public PageableResponse<SubCategoryDto> getAllSubCategories(int pageNumber, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);

        Page<SubCategory> page = subCategoryRepo.findAll(pageable);
        return Helper.getPageableResponse(page, SubCategoryDto.class);
    }

    @Override
    public SubCategoryDto getSubCategoryById(Long subCategoryId) {
        SubCategory subCategory = subCategoryRepo.findById(subCategoryId)
                .orElseThrow(() -> new ResourceNotFoundException("SubCategory", "ID", subCategoryId));
        return modelMapper.map(subCategory, SubCategoryDto.class);
    }

    @Override
    public List<SubCategoryDto> searchSubCategoryByName(String keyword) {
        List<SubCategory> subCategories = subCategoryRepo.findByNameContaining(keyword);
        return subCategories.stream()
                .map(sc -> modelMapper.map(sc, SubCategoryDto.class))
                .collect(Collectors.toList());
    }
}
