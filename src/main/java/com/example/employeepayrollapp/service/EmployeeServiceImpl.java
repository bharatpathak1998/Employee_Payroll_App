package com.example.employeepayrollapp.service;

import com.example.employeepayrollapp.model.EmployeeModel;
import com.example.employeepayrollapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public EmployeeModel save(EmployeeModel employeeModel) {
        return employeeRepository.save(employeeModel);
    }

    public List<EmployeeModel> get() {
        return employeeRepository.findAll();
    }

    public EmployeeModel getById(long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public EmployeeModel updateById(long id, EmployeeModel employeeModel) {
        employeeModel.setEmployeeId(id);
        return employeeRepository.save(employeeModel);
    }

    public void deleteById(long id) {
        employeeRepository.deleteById(id);
    }
}