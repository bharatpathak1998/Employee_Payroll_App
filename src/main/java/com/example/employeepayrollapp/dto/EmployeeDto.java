package com.example.employeepayrollapp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDto {

    private long employeeId;
    private String name;
    private String gender;
    private String address;
    private String email;
}