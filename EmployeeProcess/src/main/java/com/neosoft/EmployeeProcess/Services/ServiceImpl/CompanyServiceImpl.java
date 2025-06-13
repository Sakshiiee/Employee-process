package com.neosoft.EmployeeProcess.Services.ServiceImpl;

import com.neosoft.EmployeeProcess.Services.CompanyService;
import com.neosoft.EmployeeProcess.dtos.CompanyDto;
import com.neosoft.EmployeeProcess.dtos.PageableResponse;
import com.neosoft.EmployeeProcess.entities.Company;
import com.neosoft.EmployeeProcess.exceptions.ResourceNotFoundException;
import com.neosoft.EmployeeProcess.helper.Helper;

import com.neosoft.EmployeeProcess.repositories.CompanyRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepo companyRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public CompanyDto createCompany(CompanyDto companyDto) {
        Company company = mapper.map(companyDto, Company.class);
        Company saved = companyRepo.save(company);
        return mapper.map(saved, CompanyDto.class);
    }

    @Override
    public CompanyDto updateCompany(CompanyDto companyDto, Long companyId) {
        Company company = companyRepo.findById(companyId)
                .orElseThrow(() -> new ResourceNotFoundException("Company not found with id: " + companyId));

        company.setName(companyDto.getName());
        company.setEmail(companyDto.getEmail());
        company.setContactNumber(companyDto.getContactNumber());
        company.setAddress(companyDto.getAddress());

        Company updated = companyRepo.save(company);
        return mapper.map(updated, CompanyDto.class);
    }

    @Override
    public void deleteCompany(Long companyId) {
        Company company = companyRepo.findById(companyId)
                .orElseThrow(() -> new ResourceNotFoundException("Company not found with id: " + companyId));
        companyRepo.delete(company);
    }

    @Override
    public PageableResponse<CompanyDto> getAllCompanies(int pageNumber, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        Page<Company> page = companyRepo.findAll(pageable);
        return Helper.getPageableResponse(page, CompanyDto.class);
    }

    @Override
    public CompanyDto getCompanyById(Long companyId) {
        Company company = companyRepo.findById(companyId)
                .orElseThrow(() -> new ResourceNotFoundException("Company not found with id: " + companyId));
        return mapper.map(company, CompanyDto.class);
    }

    @Override
    public CompanyDto getCompanyByEmail(String email) {
        Company company = companyRepo.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Company not found with email: " + email));
        return mapper.map(company, CompanyDto.class);
    }

    @Override
    public List<CompanyDto> searchCompany(String keyword) {
        List<Company> companies = companyRepo.findByNameContaining(keyword);
        return companies.stream()
                .map(company -> mapper.map(company, CompanyDto.class))
                .collect(Collectors.toList());
    }
}
