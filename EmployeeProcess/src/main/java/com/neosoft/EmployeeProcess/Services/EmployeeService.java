package com.neosoft.EmployeeProcess.Services;

import com.neosoft.EmployeeProcess.dtos.EmployeeDto;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {
    EmployeeDto save(EmployeeDto dto);
}
