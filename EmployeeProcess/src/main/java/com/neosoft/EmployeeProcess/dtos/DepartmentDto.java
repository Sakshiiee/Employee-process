package com.neosoft.EmployeeProcess.dtos;

import com.neosoft.EmployeeProcess.annotations.NullOrNotBlank;
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

    @NullOrNotBlank(min = 1,max = 30,message = "Please enter your companyId name! ",isMandatory = "yes")
    private Long companyId;

    private List<Long> subCategoryId;

}
