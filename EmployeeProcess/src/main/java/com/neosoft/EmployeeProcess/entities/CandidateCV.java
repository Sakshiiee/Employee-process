package com.neosoft.EmployeeProcess.entities;

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
@Table(name = "candidateCV")
public class CandidateCV {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "candidate_name", nullable = false, length = 100)
    private String candidateName;

    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "contact_num")
    private String contactNumber;

    @Column(name = "resume_url", length = 300)
    private String resumeUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "requirement_position_id", nullable = false)
    private Requirement requirement;                       //many cand_CV has 1 requiremnet position

    @OneToMany(mappedBy = "candidateCV", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Screening> screenings;

    @ManyToMany(mappedBy = "candidates")
    @JsonIgnore
    private List<InterviewBatch> interviewBatches;
}
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
//@Table(name = "candidateCV")
//public class CandidateCV {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id", nullable = false, updatable = false)
//    private Long id;
//
//    @Column(name = "candidate_name", nullable = false, length = 100)
//    private String candidateName;
//
//    @Column(name = "email", nullable = false, unique = true, length = 100)
//    private String email;
//
//    @Column(name = "contact_num")
//    private String contactNumber;
//
//    @Column(name = "resume_url", length = 300)
//    private String resumeUrl;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "requirement_position_id", nullable = false)
//    private Requirement requirement;                       //many cand_CV has 1 requiremnet position
//
//}
