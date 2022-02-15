package africa.semicolon.employeeProgram.services;

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

    private EmployeeResponse createEmployee() {
        EmployeeRequest newRequest = new EmployeeRequest();
        newRequest.setFirstName("Shayto");
        newRequest.setLastName("Thomas");
        newRequest.setJobDescription("HR");
        return services.addEmployee(newRequest);
    }

    @Test
    void addEmployee() {
        EmployeeRequest request = new EmployeeRequest();
        EmployeeResponse response;
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
        africa.semicolon.employeeProgram.data.models.Employee employee = new africa.semicolon.employeeProgram.data.models.Employee();
        employee.setFirstName(response.getFirstName());
        employee.setJobDescription(response.getJobDescription());
        employee.setId(response.getId());
        log.info("EmployeeResponse with id {}", services.getEmployeeById(employee.getId()));
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

    @Test
    void getAllEmployees() {
        List<africa.semicolon.employeeProgram.data.models.Employee> employees = services.getAllEmployees();
        log.info("{}",employees.size());
        /*todo --> size changes with each test run
        assertThat(employees.size()).isEqualTo(41);
         */
    }

    @Test
    void updateEmployeeRecord() {
        EmployeeResponse response = createEmployee();
        log.info("EmployeeResponse with id {}", services.getEmployeeById(response.getId()));

        assertThat(services.getEmployeeById(response.getId())).isNotNull();

        EmployeeRequest newRequest = new EmployeeRequest();
        newRequest.setFirstName("Bola");
        africa.semicolon.employeeProgram.data.models.Employee employee = services.updateEmployeeRecord(response.getId(), newRequest);
        assertThat(response.getId()).isEqualTo(employee.getId());
        assertThat(employee.getFirstName()).isEqualTo("Bola");
        assertThat(employee.getJobDescription()).isEqualTo(response.getJobDescription());
        assertThat(services.getEmployeeById(employee.getId())).isEqualTo(services.getEmployeeById(response.getId()));
    }
}