package com.example.employeepayrollapp.controller;

import com.example.employeepayrollapp.dto.EmployeeDto;
import com.example.employeepayrollapp.model.EmployeeModel;
import com.example.employeepayrollapp.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/addEmployee")
    public EmployeeDto add(@Valid @RequestBody EmployeeModel employeeModel) {
        return employeeService.save(employeeModel);
    }

    @PostMapping("/addEmployees")
    public List<EmployeeDto> add(@Valid @RequestBody List<EmployeeModel> employeeModel) {
        return employeeService.saves(employeeModel);
    }

    @GetMapping("/getEmployees")
    public List<EmployeeDto> get() {
        return employeeService.getAll();
    }

    @GetMapping("/getEmployee/{id}")
    public EmployeeDto get(@PathVariable long id) {
        return employeeService.getById(id);
    }

    @PutMapping("/putEmployee/{id}")
    public EmployeeDto update(@PathVariable long id, @Valid @RequestBody EmployeeModel employeeModel) {
        return employeeService.updateById(id, employeeModel);
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public String deleteById(@PathVariable long id) {
        return employeeService.deleteById(id);
    }
}