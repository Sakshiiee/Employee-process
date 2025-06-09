package com.neosoft.EmployeeProcess.dtos;

import com.neosoft.EmployeeProcess.annotations.NullOrNotBlank;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubCategoryDto {
    private Long id;

    @NullOrNotBlank(min = 1,max = 15,message = "Please enter your name !",isMandatory = "yes")
    private String name;

    @NullOrNotBlank(min = 1,max = 15,message = "Please enter your description!",isMandatory = "yes")
    private String description;

    @NullOrNotBlank(min = 1,max = 15,message = "Please enter your department Id !",isMandatory = "yes")
    private Long departmentId;
}
