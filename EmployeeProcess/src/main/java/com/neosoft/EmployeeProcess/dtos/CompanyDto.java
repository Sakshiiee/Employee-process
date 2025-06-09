package com.neosoft.EmployeeProcess.dtos;

import com.neosoft.EmployeeProcess.annotations.NullOrNotBlank;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyDto {
    private Long id;

    @NullOrNotBlank(min = 2,max = 30,message = "Please enter name !",isMandatory = "yes")
    private String name;

    private String address;

    private String industry;

    @NullOrNotBlank(min = 1,max = 30,message = "Please enter your city name! ",isMandatory = "yes")
    private String city;

    @NullOrNotBlank(min = 1,max = 30,message = "Please enter your state name! ",isMandatory = "yes")
    private String state;

    //@Pattern(regexp = "\\d{6}", message = "PIN code must be 6 digits")
    private String pinCode;

    //@Pattern(regexp = "\\d{10}", message = "Contact number must be 10 digits")
    private String contactNum;

    @NullOrNotBlank(min = 5, max = 50, isEmail="yes",message = "Valid email address is required and must be between {min} and {max} characters")
    private String email;

    private String website;
}
