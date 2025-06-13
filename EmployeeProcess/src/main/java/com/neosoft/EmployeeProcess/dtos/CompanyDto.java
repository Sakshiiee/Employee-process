package com.neosoft.EmployeeProcess.dtos;

import com.neosoft.EmployeeProcess.annotation.NullOrNotBlank;
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

    @Pattern(regexp = "\\d{10}", message = "Contact number must be 10 digits")
    //@NullOrNotBlank(isContactNumber = "yes", message = "Contact number must be exactly 10 digits")
    private String contactNumber;

    @NullOrNotBlank(min = 5, max = 50, isEmail="yes",message = "Valid email address is required and must be between {min} and {max} characters")
    private String email;

    private String website;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
