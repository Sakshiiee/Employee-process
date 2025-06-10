package com.neosoft.EmployeeProcess.dtos;

import com.neosoft.EmployeeProcess.annotations.NullOrNotBlank;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder


public class EmployeeDto {

    private Long id;

    @NullOrNotBlank(min = 2,max = 20,message = "Please enter valid firstname",isMandatory = "yes")
    private String firstName;

    @NullOrNotBlank(min = 2,max = 20,message = "Please enter valid lastname",isMandatory = "yes")
    private String lastName;

    @NullOrNotBlank(min = 5, max = 50, isEmail="yes",message = "Valid email address is required and must be between {min} and {max} characters")
    private String email;

    //@Pattern(regexp = "\\d{10}", message = "Contact number should not be more than 10 digits")
    @NullOrNotBlank(isContactNumber = "yes", message = "Contact number must be exactly 10 digits")
    private String contactNumber;


    private Long companyId;                    //1emp -> 1company

    private Long departmentId;                 //1emp -> 1dept

    private Long subCategoryId;                //dept -> java

    private String designation;

    private String employeeCode;

//    public EmployeeDto(Long id, String firstName, String lastName, String email, String contactNumber,
//                       Long companyId, Long departmentId, Long subCategoryId, String designation, String employeeCode) {
//        this.id = id;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.email = email;
//        this.contactNumber = contactNumber;
//        this.companyId = companyId;
//        this.departmentId = departmentId;
//        this.subCategoryId = subCategoryId;
//        this.designation = designation;
//        this.employeeCode = employeeCode;
//    }

}
