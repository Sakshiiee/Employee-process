package com.neosoft.EmployeeProcess.dtos;


import com.neosoft.EmployeeProcess.annotations.NullOrNotBlank;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.processing.Pattern;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CandidateCVDto {
    private Long id;

    @NullOrNotBlank(min = 1,max = 15,message = "Please enter given field!",isMandatory = "yes")
    private String candidateName;

    @NullOrNotBlank(min = 5, max = 50, isEmail="yes",message = "Valid email address is required and must be between {min} and {max} characters")
    private String email;

    //@NotBlank(message = "Contact number is required")
    private String contactNum;

    //@NotBlank(message = "Resume URL or file path is required")
    private String resumeUrl;

    @NullOrNotBlank(min = 1,max = 500,message = "Please enter requirementPosition Id!",isMandatory = "yes")
    private Long requirementPositionId;
}
