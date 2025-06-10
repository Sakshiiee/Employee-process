package com.neosoft.EmployeeProcess.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "criteria")
public class Criteria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "requirement_id", nullable = false, unique = true)
    private Requirement requirement;            //1-1 mapping w/ req, 1 req has exact 1 criteria

    @Column(name = "min_exp_in_yrs")
    private Integer minExperienceInYears;

    @Column(name = "req_skills", length = 255)
    private String requiredSkills;

    @Column(name = "qualification_details", length = 300)
    private String qualificationDetails;
}
