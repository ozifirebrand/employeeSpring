package africa.semicolon.employeeProgram.services;

import africa.semicolon.employeeProgram.dtos.EmployeeRequest;
import africa.semicolon.employeeProgram.dtos.EmployeeResponse;

import java.util.List;

public interface EmployeeServices {
    EmployeeResponse addEmployee(EmployeeRequest employeeRequest);
    void deleteEmployee(africa.semicolon.employeeProgram.data.models.Employee employee);
    void deleteEmployeeById(Long id);
    africa.semicolon.employeeProgram.data.models.Employee updateEmployeeRecord(Long id, EmployeeRequest employeeRequest);
    EmployeeResponse getEmployeeById(Long id);
    List<africa.semicolon.employeeProgram.data.models.Employee> getAllEmployees();
}
