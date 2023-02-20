package com.example.employeepayrollapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Employee_Table")
public class EmployeeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long employeeId;

    @NotEmpty(message = "Name should not be empty!")
    private String name;

    private long salary;

    @NotEmpty(message = "Gender should not be empty!")
    private String gender;

    @NotEmpty(message = "Address should not be empty!")
    private String address;

    @NotEmpty(message = "Email should not be empty!")
    @Pattern(regexp = "^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9]+[.]co(m|.in)$", message = "Invalid email address!")
    private String email;

    @NotEmpty(message = "Phone number should not be empty!")
    @Pattern(regexp = "^\\d{10}$", message = "Invalid phone number!")
    private String phoneNumber;
}