package africa.semicolon.employeeProgram.data.repositories;

import africa.semicolon.employeeProgram.data.models.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository repository;

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void testCanAddEmployee(){

        assertThat(repository).isNull();

        Employee shayto = new Employee();
        shayto.setFirstName("Shayto");
        shayto.setLastName("Awo");
        shayto.setJobDescription("HR");

        repository.save(shayto);
//        assertThat(repository).isNotNull();

    }

}