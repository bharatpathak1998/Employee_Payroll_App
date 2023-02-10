package com.example.employeepayrollapp.controller;

import com.example.employeepayrollapp.model.EmployeeModel;
import com.example.employeepayrollapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/add")
    public EmployeeModel add(@RequestBody EmployeeModel employeeModel) {
        return employeeService.save(employeeModel);
    }

    @GetMapping("/get")
    public List<EmployeeModel> get() {
        return employeeService.get();
    }

    @GetMapping("/get/{id}")
    public EmployeeModel get(@PathVariable long id) {
        return employeeService.getById(id);
    }

    @PutMapping("/put/{id}")
    public EmployeeModel update(@PathVariable long id, @RequestBody EmployeeModel employeeModel) {
        return employeeService.updateById(id, employeeModel);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable long id) {
        employeeService.deleteById(id);
    }
}