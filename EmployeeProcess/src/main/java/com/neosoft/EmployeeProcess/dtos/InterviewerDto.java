package com.neosoft.EmployeeProcess.dtos;

import com.neosoft.EmployeeProcess.annotation.NullOrNotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InterviewerDto {
    private Long id;

    @NullOrNotBlank(min = 1,max = 500,message = "Employee ID is required!",isMandatory = "yes")
    private Long employeeId;

    @NullOrNotBlank(min = 1,max = 500,message = "Interview batch ID!",isMandatory = "yes")
    private Long interviewBatchId;

    @NullOrNotBlank(min = 1,max = 500,message = "Role description can be max 100 characters!",isMandatory = "yes")
    private String roleInInterview;

    @NullOrNotBlank(min = 1,max = 500,message = "Comments cn be 500 character!",isMandatory = "yes")
    private String feedback;
}
