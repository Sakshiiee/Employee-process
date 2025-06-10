package com.neosoft.EmployeeProcess.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "screening")
public class Screening {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "candidate_cv_id", nullable = false)
    private CandidateCV candidateCV;                      //many sc has 1 candidate CV

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "requirement_criteria_id", nullable = false)
    private Criteria requirementCriteria;                    //many sc has 1 req criteria

    @Column(name = "status", nullable = false, length = 50)
    private String status;
}
