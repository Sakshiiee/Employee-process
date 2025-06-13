package com.neosoft.EmployeeProcess.dtos;

import com.neosoft.EmployeeProcess.annotation.NullOrNotBlank;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CriteriaDto {
    private Long id;

    @NullOrNotBlank(min = 1,max = 15,message = "Please enter your Requiremnet/position Id !",isMandatory = "yes")
    private Long requirementId; // Links to Requirement/Position

    @NotNull(message = "Minimum experience is required")
    @Min(value = 0, message = "Experience cannot be negative")
    private Integer minExperienceInYears;

    @NullOrNotBlank(min = 1,max = 200,message = "Please enter your name !",isMandatory = "yes")
    private String requiredSkills;  // e.g., Java, Spring Boot, Microservices

    @NullOrNotBlank(min = 2,max = 100,message = "Please enter your name !",isMandatory = "yes")
    private String qualificationDetails;

}
