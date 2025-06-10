package com.neosoft.EmployeeProcess.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "company_seq")
    @SequenceGenerator(name = "company_seq", sequenceName = "COMPANY_SEQ", allocationSize = 1)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

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
}
