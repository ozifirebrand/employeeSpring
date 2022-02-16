package africa.semicolon.employeeProgram.services.employee;

import africa.semicolon.employeeProgram.data.models.Employee;
import africa.semicolon.employeeProgram.dtos.EmployeeRequest;
import africa.semicolon.employeeProgram.dtos.EmployeeResponse;

import java.util.List;

public interface EmployeeServices {
    EmployeeResponse addEmployee(EmployeeRequest employeeRequest);
    void deleteEmployee(Employee employee);
    void deleteEmployeeById(Long id);
    Employee updateEmployeeRecord(Long id, EmployeeRequest employeeRequest);
    EmployeeResponse getEmployeeById(Long id);
    List<Employee> getAllEmployees();
    void deleteAllEmployees();

}
