package com.neosoft.EmployeeProcess.Controller;

import com.neosoft.EmployeeProcess.Services.EmployeeService;
import com.neosoft.EmployeeProcess.dtos.EmployeeDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
@Validated
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/save")
    public EmployeeDto createEmployee(@Valid @RequestBody EmployeeDto employeeDto) {
        return employeeService.save(employeeDto);
    }


}