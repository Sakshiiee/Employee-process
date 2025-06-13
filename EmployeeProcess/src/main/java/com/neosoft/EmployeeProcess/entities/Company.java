//package com.neosoft.EmployeeProcess.entities;
//
//import jakarta.persistence.*;
//import lombok.*;
//
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//@Entity
//@Table(name = "company")
//public class Company {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id", nullable = false, updatable = false)
//    private Long id;
//
//    @Column(name = "name", nullable = false, length = 100)
//    private String name;
//
//    @Column(name = "address", length = 250)
//    private String address;
//
//    @Column(name = "industry", length = 100)
//    private String industry;
//
//    @Column(name = "city", length = 50)
//    private String city;
//
//    @Column(name = "state", length = 50)
//    private String state;
//
//    @Column(name = "pin_code", length = 6)
//    private String pinCode;
//
//    @Column(name = "contact_number", length = 15)
//    private String contactNumber;
//
//    @Column(name = "email", length = 100, unique = true)
//    private String email;
//
//    @Column(name = "website", length = 150)
//    private String website;
//}
package com.neosoft.EmployeeProcess.entities;

import com.neosoft.EmployeeProcess.annotation.NullOrNotBlank;
import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)

    private Long id;
    //@NullOrNotBlank(min = 2,max = 30,message = "Please enter name !",isMandatory = "yes")
    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "address", length = 250)
    private String address;

    @Column(name = "industry", length = 100)
    private String industry;

    @Column(name = "city", length = 50)
    private String city;

    @Column(name = "state", length = 50)
    private String state;

    @Column(name = "pin_code", length = 6)
    private String pinCode;

    @Column(name = "contact_number", length = 15)
    private String contactNumber;

    @Column(name = "email", length = 100, unique = true)
    private String email;

    @Column(name = "website", length = 150)
    private String website;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Department> departments;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Employee> employees;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
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

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }
}