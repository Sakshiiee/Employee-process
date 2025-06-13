package com.neosoft.EmployeeProcess.Controller;

import com.neosoft.EmployeeProcess.Services.DepartmentService;
import com.neosoft.EmployeeProcess.dtos.DepartmentDto;
import com.neosoft.EmployeeProcess.dtos.PageableResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    // Create
    @PostMapping
    public DepartmentDto createDepartment(@Valid @RequestBody DepartmentDto dto) {
        return departmentService.createDepartment(dto);
    }

    // Update
    @PutMapping("/{departmentId}")
    public DepartmentDto updateDepartment(@Valid @RequestBody DepartmentDto dto,
                                          @PathVariable Long departmentId) {
        return departmentService.updateDepartment(dto, departmentId);
    }

    // Delete
    @DeleteMapping("/{departmentId}")
    public ResponseEntity<String> deleteDepartment(@PathVariable Long departmentId) {
        departmentService.deleteDepartment(departmentId);
        return ResponseEntity.ok("Department deleted successfully");
    }

    // Get all
    @GetMapping
    public ResponseEntity<PageableResponse<DepartmentDto>> getAllDepartments(
            @RequestParam(value = "pageNumber", defaultValue = "0", required = false) int pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "5", required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = "name", required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = "asc", required = false) String sortDir
    ) {
        PageableResponse<DepartmentDto> response = departmentService.getAllDepartments(pageNumber, pageSize, sortBy, sortDir);
        return ResponseEntity.ok(response);
    }


    // Get by ID
    @GetMapping("/{departmentId}")
    public DepartmentDto getDepartmentById(@PathVariable Long departmentId) {
        return departmentService.getDepartmentById(departmentId);
    }

    // Search by Name
    @GetMapping("/search/{keywords}")
    public ResponseEntity<List<DepartmentDto>> searchDepartment(@PathVariable String keywords) {
        List<DepartmentDto> departments = departmentService.searchDepartment(keywords);
        return ResponseEntity.ok(departments);
    }

}
