package com.neosoft.EmployeeProcess.Controller;

import com.neosoft.EmployeeProcess.Services.EmployeeService;
import com.neosoft.EmployeeProcess.dtos.EmployeeDto;
import com.neosoft.EmployeeProcess.repositories.EmployeeRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/save")
    public EmployeeDto createEmployee(@Valid @RequestBody EmployeeDto employeeDto) {
        return employeeService.save(employeeDto);
    }


}