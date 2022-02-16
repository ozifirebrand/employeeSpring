package africa.semicolon.employeeProgram.controllers;

import africa.semicolon.employeeProgram.dtos.EmployeeRequest;
import africa.semicolon.employeeProgram.services.employee.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("api/employee")
public class EmployeeController {
    @Autowired
    private EmployeeServices services;

    @PostMapping
    public ResponseEntity<?> createEmployee(@RequestBody EmployeeRequest request){

//        services.addEmployee()
        return null;
    }
}
