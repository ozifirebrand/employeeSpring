package africa.semicolon.employeeProgram.services;

import africa.semicolon.employeeProgram.data.models.Employee;
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
        services.deleteAllEmployees();
    }

    private EmployeeResponse createEmployee() {
        EmployeeRequest newRequest = new EmployeeRequest();
        newRequest.setFirstName("Shayto");
        newRequest.setLastName("Thomas");
        newRequest.setJobDescription("HR");
        return services.addEmployee(newRequest);
    }

    @Test
    public void addEmployee() {
        EmployeeResponse response= createEmployee();
        log.info("id of response is {}", response.getId());

        assertThat(response).isNotNull();
        assertThat(response.getId()).isNotNull();
        assertThat(response.getFirstName()).isEqualTo("Shayto");
        assertThat(response.getJobDescription()).isEqualTo("HR");
    }

//    @Test
//    public void testCanEmployeeOnceAlone(){
//        createEmployee();
//    }


    @Test
    public void deleteEmployeeById() {
        EmployeeResponse newResponse = createEmployee();
        services.deleteEmployeeById(newResponse.getId());
        EmployeeResponse responseAgain = services.getEmployeeById(newResponse.getId());
        assertThat(responseAgain).isNull();

    }

    @Test
    public void deleteEmployee() {
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
    public void getEmployeeById() {
        EmployeeResponse response = createEmployee();
        EmployeeResponse foundResponse = services.getEmployeeById(response.getId());
        assertThat(foundResponse.getId()).isEqualTo(response.getId());
        assertThat(foundResponse.getFirstName()).isEqualTo(response.getFirstName());
        assertThat(foundResponse.getJobDescription()).isEqualTo(response.getJobDescription());
    }

    @Test
    public void getAllEmployees() {
        List<Employee> employees = services.getAllEmployees();
        log.info("{}",employees.size());
        assertThat(employees.size()).isEqualTo(0);
        createEmployee();
        createEmployee();
        createEmployee();
        assertThat(services.getAllEmployees().size()).isEqualTo(3);


    }

    @Test
    public void updateEmployeeRecord() {
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