package africa.semicolon.employeeProgram.services.employee;

import africa.semicolon.employeeProgram.data.models.Employee;
import africa.semicolon.employeeProgram.data.repositories.EmployeeRepository;
import africa.semicolon.employeeProgram.dtos.EmployeeRequest;
import africa.semicolon.employeeProgram.dtos.EmployeeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class EmployeeServicesImpl implements EmployeeServices {

    @Autowired
    private EmployeeRepository repository;

    @Override
    public EmployeeResponse addEmployee(EmployeeRequest employeeRequest){
        Employee newEmployee = getEmployee(employeeRequest);
        repository.save(newEmployee);
        return getResponse(newEmployee);

    }

    private EmployeeResponse getResponse(Employee newEmployee) {
        EmployeeResponse response = new EmployeeResponse();
        response.setFirstName(newEmployee.getFirstName());
        response.setId(newEmployee.getId());
        response.setJobDescription(newEmployee.getJobDescription());
        return response;
    }

    private Employee getEmployee(EmployeeRequest employeeRequest) {
        Employee newEmployee = new Employee();
        newEmployee.setJobDescription(employeeRequest.getJobDescription());
        newEmployee.setLastName(employeeRequest.getLastName());
        newEmployee.setJobDescription(employeeRequest.getJobDescription());
        newEmployee.setFirstName(employeeRequest.getFirstName());

        return newEmployee;
    }

    @Override
    public void deleteEmployeeById(Long id){
        repository.deleteById(id);
    }

    @Override
    public Employee updateEmployeeRecord(Long id, EmployeeRequest employeeRequest) {
        Optional<Employee> optionalEmployee = repository.findById(id);
        if ( optionalEmployee.isPresent() ){
            Employee employee = optionalEmployee.get();
            employee.setFirstName(employeeRequest.getFirstName());

            return employee;
        }
        return null;
    }

    @Override
    public void deleteEmployee(Employee employee) {
        repository.delete(employee);
    }

    @Override
    public EmployeeResponse getEmployeeById(Long id) {
        EmployeeResponse response = new EmployeeResponse();
        Optional<Employee> optionalEmployee = repository.findById(id);
        if ( optionalEmployee.isPresent() ) {
            Employee employee = optionalEmployee.get();
            response.setFirstName(employee.getFirstName());
            response.setJobDescription(employee.getJobDescription());
            response.setId(employee.getId());
            return response;
        }
        return null;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    @Override
    public void deleteAllEmployees() {
        repository.deleteAll();
        repository.findAll();
    }

    @Override
    public Map<?, ?> uploadEmployeePicture(byte[] bytes, Map<?, ?> params) {
        return null;
    }

    @Override
    public String generateEmployeeId(Employee employee) {
        return null;
    }
}
