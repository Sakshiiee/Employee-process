package com.neosoft.EmployeeProcess.dtos;


import com.neosoft.EmployeeProcess.annotations.NullOrNotBlank;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequirementDto {
    private Long id;

    @NullOrNotBlank(min = 1,max = 30,message = "Please enter your position Title! ",isMandatory = "yes")
    private String positionTitle;                       //like hr, java developer

    @NullOrNotBlank(min = 1,max = 30,message = "Please enter your departmentId! ",isMandatory = "yes")
    private Long departmentId;

    private Long subCategoryId;

    @NotNull(message = "Number of openings is required")           //
    @Min(value = 1, message = "At least one opening is required")
    private Integer numberOfOpenings;

    @NullOrNotBlank(min = 1,max = 30,message = "Please enter your job description! ",isMandatory = "yes")
    private String jobDescription;

    @NotNull(message = "Experience required is mandatory")             //
    @Min(value = 0, message = "Experience cannot be negative")
    private Integer experienceInYears;

    @NullOrNotBlank(min = 1,max = 30,message = "Please enter your skills! ",isMandatory = "yes")
    private String skillsRequired;

    private String location;


}
