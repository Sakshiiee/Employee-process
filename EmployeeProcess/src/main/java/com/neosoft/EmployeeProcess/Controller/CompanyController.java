package com.neosoft.EmployeeProcess.Controller;

import com.neosoft.EmployeeProcess.Services.CompanyService;
import com.neosoft.EmployeeProcess.dtos.CompanyDto;
import com.neosoft.EmployeeProcess.dtos.PageableResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    // Create
    @PostMapping
    public ResponseEntity<CompanyDto> createCompany(@Valid @RequestBody CompanyDto companyDto) {
        CompanyDto createdCompany = companyService.createCompany(companyDto);
        return ResponseEntity.status(201).body(createdCompany); // 201 Created
    }

    // Update
    @PutMapping("/{companyId}")
    public ResponseEntity<CompanyDto> updateCompany(@Valid @RequestBody CompanyDto companyDto,
                                                    @PathVariable Long companyId) {
        CompanyDto updatedCompany = companyService.updateCompany(companyDto, companyId);
        return ResponseEntity.ok(updatedCompany);
    }

    // Delete
    @DeleteMapping("/{companyId}")
    public ResponseEntity<String> deleteCompany(@PathVariable Long companyId) {
        companyService.deleteCompany(companyId);
        return ResponseEntity.ok("Company deleted successfully with ID: " + companyId);
    }

    // Get All
    @GetMapping
    public ResponseEntity<PageableResponse<CompanyDto>> getAllCompanies(
            @RequestParam(value = "pageNumber", defaultValue = "0", required = false) int pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "5", required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = "name", required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = "asc", required = false) String sortDir
    ) {
        PageableResponse<CompanyDto> allCompanies = companyService.getAllCompanies(pageNumber, pageSize, sortBy, sortDir);
        return ResponseEntity.ok(allCompanies);
    }


    // Get By ID
    @GetMapping("/{companyId}")
    public ResponseEntity<CompanyDto> getCompanyById(@PathVariable Long companyId) {
        CompanyDto company = companyService.getCompanyById(companyId);
        return ResponseEntity.ok(company);
    }

    // Get By Email
    @GetMapping("/email/{email}")
    public ResponseEntity<CompanyDto> getCompanyByEmail(@PathVariable String email) {
        CompanyDto company = companyService.getCompanyByEmail(email);
        return ResponseEntity.ok(company);
    }

    // Search by Name
    @GetMapping("/search/{keywords}")
    public ResponseEntity<List<CompanyDto>> searchCompany(@PathVariable String keywords) {
        List<CompanyDto> companies = companyService.searchCompany(keywords);
        return ResponseEntity.ok(companies);
    }
}
