package africa.semicolon.employeeProgram.services;

import africa.semicolon.employeeProgram.data.repositories.EmployeeRepository;
import africa.semicolon.employeeProgram.dtos.EmployeeRequest;
import africa.semicolon.employeeProgram.dtos.EmployeeResponse;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
    }

    @Test
    void updateEmployeeRecord() {
    }
}