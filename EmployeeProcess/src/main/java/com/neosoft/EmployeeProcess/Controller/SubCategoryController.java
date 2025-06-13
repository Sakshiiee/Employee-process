package com.neosoft.EmployeeProcess.Controller;

import com.neosoft.EmployeeProcess.Services.SubCategoryService;
import com.neosoft.EmployeeProcess.dtos.PageableResponse;
import com.neosoft.EmployeeProcess.dtos.SubCategoryDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subCategories")
public class SubCategoryController {

    @Autowired
    private SubCategoryService subCategoryService;

    // Create
    @PostMapping
    public ResponseEntity<SubCategoryDto> createSubCategory(@Valid @RequestBody SubCategoryDto dto) {
        SubCategoryDto created = subCategoryService.createSubCategory(dto);
        return ResponseEntity.status(201).body(created);
    }

    // Update
    @PutMapping("/{subCategoryId}")
    public ResponseEntity<SubCategoryDto> updateSubCategory(@Valid @RequestBody SubCategoryDto dto,
                                                            @PathVariable Long subCategoryId) {
        SubCategoryDto updated = subCategoryService.updateSubCategory(dto, subCategoryId);
        return ResponseEntity.ok(updated);
    }

    // Delete
    @DeleteMapping("/{subCategoryId}")
    public ResponseEntity<String> deleteSubCategory(@PathVariable Long subCategoryId) {
        subCategoryService.deleteSubCategory(subCategoryId);
        return ResponseEntity.ok("SubCategory deleted successfully with ID: " + subCategoryId);
    }

    // Get All
    @GetMapping
    public ResponseEntity<PageableResponse<SubCategoryDto>> getAllSubCategories(
            @RequestParam(value = "pageNumber", defaultValue = "0", required = false) int pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "5", required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = "name", required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = "asc", required = false) String sortDir
    ) {
        PageableResponse<SubCategoryDto> all = subCategoryService.getAllSubCategories(pageNumber, pageSize, sortBy, sortDir);
        return ResponseEntity.ok(all);
    }

    // Get By ID
    @GetMapping("/{subCategoryId}")
    public ResponseEntity<SubCategoryDto> getSubCategoryById(@PathVariable Long subCategoryId) {
        SubCategoryDto subCategory = subCategoryService.getSubCategoryById(subCategoryId);
        return ResponseEntity.ok(subCategory);
    }

    // Search by Name
    @GetMapping("/search/{keywords}")
    public ResponseEntity<List<SubCategoryDto>> searchSubCategory(@PathVariable String keywords) {
        List<SubCategoryDto> results = subCategoryService.searchSubCategoryByName(keywords);
        return ResponseEntity.ok(results);
    }

}
