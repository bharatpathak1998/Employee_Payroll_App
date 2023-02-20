package com.example.employeepayrollapp.service;

import com.example.employeepayrollapp.dto.EmployeeDto;
import com.example.employeepayrollapp.model.EmployeeModel;
import com.example.employeepayrollapp.repository.EmployeeRepository;
import com.example.employeepayrollapp.exception.EmployeeNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    ModelMapper modelMapper;

    // Here we are create a save method to save the employee in the database :-
    public EmployeeDto save(EmployeeModel employeeModel) {
        EmployeeModel saveEmployee = employeeRepository.save(employeeModel);
        return modelMapper.map(saveEmployee, EmployeeDto.class);
    }

    // Here we are create a saves method to save list of employees in the database :-
    @Override
    public List<EmployeeDto> saves(List<EmployeeModel> employeeModel) {
        List<EmployeeModel> employeeModelList = employeeRepository.saveAll(employeeModel);
        return employeeModelList.stream().map(i ->
                modelMapper.map(i, EmployeeDto.class)).collect(Collectors.toList());
    }

    // Here we are create a getAll method to get All the employees from the database :-
    public List<EmployeeDto> getAll() {
        List<EmployeeModel> allEmployeeList = employeeRepository.findAll();
        return allEmployeeList.stream().map((EmployeeModel employeeModel) ->
                modelMapper.map(employeeModel, EmployeeDto.class)).collect(Collectors.toList());
    }

    // Here we are create a getById method to get the particular employee from the database :-
    public EmployeeDto getById(long id) {
        EmployeeModel employeeModel = employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("employee", id));
        return modelMapper.map(employeeModel, EmployeeDto.class);
    }

    // Here we are create a updateById method to update particular employee from the database :-
    public EmployeeDto updateById(long id, EmployeeModel employeeModel) {
        employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("employee", id));
        employeeModel.setEmployeeId(id);
        EmployeeModel updateEmployee = employeeRepository.save(employeeModel);
        return modelMapper.map(updateEmployee, EmployeeDto.class);
    }

    // Here we are create a deleteById method to delete particular employee from the database :-
    public String deleteById(long id) {
        EmployeeModel employeeModel = employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("employee", id));
        employeeRepository.delete(employeeModel);
        return "Employee deleted successfully.";
    }
}