package com.neosoft.EmployeeProcess.dtos;

import com.neosoft.EmployeeProcess.annotation.NullOrNotBlank;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DepartmentDto {
    private Long id;

    @NullOrNotBlank(min = 1,max = 30,message = "Please enter your department name! ",isMandatory = "yes")
    private String name;

    private String description;

    @NotNull(message = "CompanyId is required!")
    private Long companyId;

    private List<Long> subCategoryId;

    private List<EmployeeDto> employees;

    private List<RequirementDto> requirements;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Long> getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(List<Long> subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public @NotNull(message = "CompanyId is required!") Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(@NotNull(message = "CompanyId is required!") Long companyId) {
        this.companyId = companyId;
    }

    public List<EmployeeDto> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeDto> employees) {
        this.employees = employees;
    }

    public List<RequirementDto> getRequirements() {
        return requirements;
    }

    public void setRequirements(List<RequirementDto> requirements) {
        this.requirements = requirements;
    }
}
