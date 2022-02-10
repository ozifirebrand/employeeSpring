package africa.semicolon.employeeProgram.services;

import africa.semicolon.employeeProgram.data.models.Employee;
import africa.semicolon.employeeProgram.data.repositories.EmployeeRepository;
import africa.semicolon.employeeProgram.dtos.EmployeeRequest;
import africa.semicolon.employeeProgram.dtos.EmployeeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServicesImpl implements EmployeeServices {

    @Autowired
    private EmployeeRepository repository;

    @Override
    public EmployeeResponse addEmployee(EmployeeRequest employeeRequest){
        Employee newEmployee = new Employee();
        newEmployee.setJobDescription(employeeRequest.getJobDescription());
        newEmployee.setLastName(employeeRequest.getLastName());
        newEmployee.setJobDescription(employeeRequest.getJobDescription());
        repository.save(newEmployee);
        EmployeeResponse response = new EmployeeResponse();
        response.setFirstName(newEmployee.getFirstName());
        response.setId(newEmployee.getId());
        response.setJobDescription(newEmployee.getJobDescription());
        return response;

    }
    @Override
    public void deleteEmployeeById(Long id){

    }

    @Override
    public void deleteEmployee(Employee employee) {

    }

    @Override
    public EmployeeResponse getEmployeeById(Long id) {
        return null;
    }

    @Override
    public EmployeeResponse getAllEmployees(Long id) {
        return null;
    }
}
