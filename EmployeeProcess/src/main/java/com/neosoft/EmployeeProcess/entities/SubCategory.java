package com.neosoft.EmployeeProcess.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "sub_category")
public class SubCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subcat_seq")
    @SequenceGenerator(name = "subcat_seq", sequenceName = "SUBCATEGORY_SEQ", allocationSize = 1)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "description", length = 250)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;               // Many SubCategories has 1 Dept
}
