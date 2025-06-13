package com.neosoft.EmployeeProcess.dtos;

import com.neosoft.EmployeeProcess.annotation.NullOrNotBlank;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubCategoryDto {
    private Long id;

    @NullOrNotBlank(min = 1, max = 100, message = "Please enter your name!", isMandatory = "yes")
    private String name;

    @NullOrNotBlank(min = 1, max = 250, message = "Please enter your description!", isMandatory = "yes")
    private String description;

    @NotNull(message = "Department ID is required")
    private Long departmentId;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }
}
