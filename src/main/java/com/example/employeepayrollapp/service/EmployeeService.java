package com.example.employeepayrollapp.service;

import com.example.employeepayrollapp.dto.EmployeeDto;
import com.example.employeepayrollapp.model.EmployeeModel;

import java.util.List;

public interface EmployeeService {

    EmployeeDto save(EmployeeModel employeeModel);

    List<EmployeeDto> saves(List<EmployeeModel> employeeModel);

    List<EmployeeDto> getAll();

    EmployeeDto getById(long id);

    EmployeeDto updateById(long id, EmployeeModel employeeModel);

    String deleteById(long id);
}