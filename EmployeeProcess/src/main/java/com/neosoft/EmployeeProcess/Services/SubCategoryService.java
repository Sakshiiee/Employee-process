package com.neosoft.EmployeeProcess.Services;

import com.neosoft.EmployeeProcess.dtos.PageableResponse;
import com.neosoft.EmployeeProcess.dtos.SubCategoryDto;

import java.util.List;

public interface SubCategoryService {

    SubCategoryDto createSubCategory(SubCategoryDto subCategoryDto);

    SubCategoryDto updateSubCategory(SubCategoryDto subCategoryDto, Long subCategoryId);

    void deleteSubCategory(Long subCategoryId);

    PageableResponse<SubCategoryDto> getAllSubCategories(int pageNumber, int pageSize, String sortBy, String sortDir);

    SubCategoryDto getSubCategoryById(Long subCategoryId);

    List<SubCategoryDto> searchSubCategoryByName(String keyword);
}
