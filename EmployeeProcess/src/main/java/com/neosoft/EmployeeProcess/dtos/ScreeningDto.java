package com.neosoft.EmployeeProcess.dtos;


import com.neosoft.EmployeeProcess.annotation.NullOrNotBlank;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ScreeningDto {
    private Long id;

    @NullOrNotBlank(min = 1,max = 100,message = "Please enter Candidate CV Id!",isMandatory = "yes")
    private Long candidateCvId;

    @NullOrNotBlank(min = 1,max = 15,message = "Please enter requirement criteria Id!",isMandatory = "yes")
    private Long requirementCriteriaId;

    @NullOrNotBlank(min = 1,max = 15,message = "Status is required!",isMandatory = "yes")
    private String status;

}
