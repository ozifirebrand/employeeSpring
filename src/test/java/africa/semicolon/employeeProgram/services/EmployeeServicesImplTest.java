package africa.semicolon.employeeProgram.services;

import africa.semicolon.employeeProgram.data.models.Employee;
import africa.semicolon.employeeProgram.data.repositories.EmployeeRepository;
import africa.semicolon.employeeProgram.dtos.EmployeeRequest;
import africa.semicolon.employeeProgram.dtos.EmployeeResponse;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class EmployeeServicesImplTest {

    @Autowired
    private EmployeeServices services;

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addEmployee() {
        EmployeeRequest request = new EmployeeRequest();
        EmployeeResponse response = new EmployeeResponse();
        request.setFirstName("Shayto");
        request.setLastName("Thomas");
        request.setJobDescription("HR");
        response = services.addEmployee(request);
        log.info("id of response is {}", response.getId());

        assertThat(response).isNotNull();
        assertThat(response.getId()).isNotNull();
        assertThat(response.getFirstName()).isEqualTo("Shayto");
        assertThat(response.getJobDescription()).isEqualTo("HR");
    }

    @Test
    void deleteEmployeeById() {
        EmployeeResponse newResponse = createEmployee();
        services.deleteEmployeeById(newResponse.getId());
        EmployeeResponse responseAgain = services.getEmployeeById(newResponse.getId());
        assertThat(responseAgain).isNull();

    }

    @Test
    void deleteEmployee() {
        EmployeeResponse response= createEmployee();
        Employee employee = new Employee();
        employee.setFirstName(response.getFirstName());
        employee.setJobDescription(response.getJobDescription());
        employee.setId(response.getId());
        log.info("Employee with id {}", services.getEmployeeById(employee.getId()));
        services.deleteEmployee(employee);
        assertThat(services.getEmployeeById(employee.getId())).isNull();
        log.info("is now {}", services.getEmployeeById(employee.getId()));
    }

    @Test
    void getEmployeeById() {
        EmployeeResponse response = createEmployee();
        EmployeeResponse foundResponse = services.getEmployeeById(response.getId());
        assertThat(foundResponse.getId()).isEqualTo(response.getId());
        assertThat(foundResponse.getFirstName()).isEqualTo(response.getFirstName());
        assertThat(foundResponse.getJobDescription()).isEqualTo(response.getJobDescription());
    }

    private EmployeeResponse createEmployee() {
        EmployeeRequest newRequest = new EmployeeRequest();
        newRequest.setFirstName("Shayto");
        newRequest.setLastName("Thomas");
        newRequest.setJobDescription("HR");
        return services.addEmployee(newRequest);
    }

    @Test
    void getAllEmployees() {
        List<Employee> employees = services.getAllEmployees();
        log.info("{}",employees.size());
        assertThat(employees.size()).isEqualTo(41);
    }

    @Test
    void updateEmployeeRecord() {
    }
}