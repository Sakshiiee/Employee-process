package com.neosoft.EmployeeProcess.Services;

import com.neosoft.EmployeeProcess.dtos.CompanyDto;
import com.neosoft.EmployeeProcess.dtos.PageableResponse;

import java.util.List;

public interface CompanyService {

    CompanyDto createCompany(CompanyDto companyDto);

    CompanyDto updateCompany(CompanyDto companyDto, Long companyId);

    void deleteCompany(Long companyId);

    PageableResponse<CompanyDto> getAllCompanies(int pageNumber, int pageSize, String sortBy, String sortDir);

    CompanyDto getCompanyById(Long companyId);

    CompanyDto getCompanyByEmail(String email);

    List<CompanyDto> searchCompany(String keyword);
}
