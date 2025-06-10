package com.neosoft.EmployeeProcess.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "requirement")
public class Requirement {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "requirement_seq")
    @SequenceGenerator(name = "requirement_seq", sequenceName = "REQUIREMENT_SEQ", allocationSize = 1)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "position_title", nullable = false, length = 100)
    private String positionTitle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;                  // Many req has 1 dept

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sub_category_id")
    private SubCategory subCategory;                 //Many req has 1 subcategory

    @Column(name = "num_of_openings")
    private Integer numberOfOpenings;

    @Column(name = "job_description", columnDefinition = "TEXT")
    private String jobDescription;

    @Column(name = "exp_in_yrs")
    private Integer experienceInYears;

    @Column(name = "skills", length = 300)
    private String skillsRequired;

    @Column(name = "location", length = 100)
    private String location;
}
