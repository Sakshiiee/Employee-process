package com.neosoft.EmployeeProcess.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "interview_batch")
public class InterviewBatch {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "interview_batch_seq")
    @SequenceGenerator(name = "interview_batch_seq", sequenceName = "INTERVIEW_BATCH_SEQ", allocationSize = 1)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "requirement_position_id", nullable = false)
    private Requirement requirement;                       //many batches has 1 reu position

    @Column(name = "interview_date", nullable = false)
    private LocalDate interviewDate;

    @Column(name = "start_time")
    private LocalTime startTime;

    @Column(name = "end_time")
    private LocalTime endTime;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "interview_batch_candidates",
            joinColumns = @JoinColumn(name = "interview_batch_id"),
            inverseJoinColumns = @JoinColumn(name = "candidate_cv_id")
    )
    private List<CandidateCV> candidates;                            //many candidates has many interview batches

    @Column(name = "location", length = 100)
    private String location;

    @Column(name = "mode", length = 50)
    private String mode;
}
