package com.neosoft.EmployeeProcess.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "interviewer")
public class Interviewer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;                             //many interviers has 1 emp

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "interviewer_batches",
            joinColumns = @JoinColumn(name = "interviewer_id"),
            inverseJoinColumns = @JoinColumn(name = "interview_batch_id")
    )
    private List<InterviewBatch> interviewBatches;                        //many interviewers has many batches

    @Column(name = "role_in_interview", length = 50)
    private String roleInInterview;

    @Column(name = "feedback", length = 1000)
    private String feedback;
}
//package com.neosoft.EmployeeProcess.entities;
//
//import jakarta.persistence.*;
//import lombok.*;
//
//import java.util.List;
//
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
//@Entity
//@Table(name = "interviewer")
//public class Interviewer {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id", nullable = false, updatable = false)
//    private Long id;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "employee_id", nullable = false)
//    private Employee employee;                             //many interviers has 1 emp
//
//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(
//            name = "interviewer_batches",
//            joinColumns = @JoinColumn(name = "interviewer_id"),
//            inverseJoinColumns = @JoinColumn(name = "interview_batch_id")
//    )
//    private List<InterviewBatch> interviewBatches;                        //many interviewers has many batches
//
//    @Column(name = "role_in_interview", length = 50)
//    private String roleInInterview;
//
//    @Column(name = "feedback", length = 1000)
//    private String feedback;
//}
