package com.neosoft.EmployeeProcess.dtos;

import com.neosoft.EmployeeProcess.annotation.NullOrNotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InterviewBatchDto {
    private Long id;

    @NullOrNotBlank(min = 1,max = 500,message = "Job position ID is required!",isMandatory = "yes")
    private Long requirementPositionId;

    @NullOrNotBlank(min = 1,max = 500,message = "Interview date is required!",isMandatory = "yes")
    private LocalDate interviewDate;

    @NullOrNotBlank(min = 1,max = 500,message = "Interview start time is required!",isMandatory = "yes")
    private LocalTime startTime;

    private LocalTime endTime;

    @NullOrNotBlank(min = 1,max = 5,message = "Atleast one candidate is required!",isMandatory = "yes")
    private List<Long> candidateIds;

    private String location;

    private String mode;
}
