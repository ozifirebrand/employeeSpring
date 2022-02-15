package africa.semicolon.employeeProgram.controllers;

import africa.semicolon.employeeProgram.data.models.Employee;
import africa.semicolon.employeeProgram.services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("api/employee")
public class EmployeeController {
    @Autowired
    private EmployeeServices services;

    @PostMapping
    public ResponseEntity<?> createEmployee(){

        return ResponseEntity.status(200).body(new Employee());
    }
}
