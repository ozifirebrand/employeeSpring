package africa.semicolon.employeeProgram.services;

import africa.semicolon.employeeProgram.data.models.Employee;
import africa.semicolon.employeeProgram.dtos.EmployeeRequest;
import africa.semicolon.employeeProgram.dtos.EmployeeResponse;

public interface EmployeeServices {
    EmployeeResponse addEmployee(EmployeeRequest employeeRequest);
    void deleteEmployeeById(Long id);
    void deleteEmployee(Employee employee);
    EmployeeResponse getEmployeeById(Long id);
    EmployeeResponse getAllEmployees(Long id);
}
