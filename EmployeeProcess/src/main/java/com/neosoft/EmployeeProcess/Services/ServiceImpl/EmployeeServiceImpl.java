package com.neosoft.EmployeeProcess.Services.ServiceImpl;

import com.neosoft.EmployeeProcess.Services.EmployeeService;
import com.neosoft.EmployeeProcess.dtos.EmployeeDto;
import com.neosoft.EmployeeProcess.repositories.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



    @Service
    public class EmployeeServiceImpl implements EmployeeService {

        private final List<EmployeeDto> empList = new ArrayList<>();

        @Override
        public EmployeeDto save(EmployeeDto dto) {
            empList.add(dto);
            return dto;
        }
}
