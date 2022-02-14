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
        request.setFirstName("Shayto");
        request.setLastName("Thomas");
        request.setJobDescription("HR");
        log.info("repository is :: {}", services);
        EmployeeResponse response = services.addEmployee(request);

        assertThat(response).isNotNull();
        log.info("id of response is {}", response.getId());
        assertThat(response.getId()).isNotNull();
        assertThat(response.getFirstName()).isEqualTo("Shayto");
        assertThat(response.getJobDescription()).isEqualTo("HR");


    }

    @Test
    void deleteEmployeeById() {
    }

    @Test
    void deleteEmployee() {
    }

    @Test
    void getEmployeeById() {
    }

    @Test
    void getAllEmployees() {
    }
}