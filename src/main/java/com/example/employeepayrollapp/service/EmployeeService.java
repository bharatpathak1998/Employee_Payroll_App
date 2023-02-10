package com.example.employeepayrollapp.service;

import com.example.employeepayrollapp.model.EmployeeModel;

import java.util.List;

public interface EmployeeService {

    EmployeeModel save(EmployeeModel employeeModel);

    List<EmployeeModel> get();

    EmployeeModel getById(long id);

    EmployeeModel updateById(long id, EmployeeModel employeeModel);

    void deleteById(long id);
}