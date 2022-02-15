package africa.semicolon.employeeProgram.data.repositories;

import africa.semicolon.employeeProgram.data.models.Employee;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository repository;

    private Employee shayto;
    @BeforeEach
    void setUp() {
        shayto = new Employee();
        shayto.setFirstName("Shayto");
        shayto.setLastName("Awo");
        shayto.setJobDescription("HR");
        repository.save(shayto);


    }

    @AfterEach
    void tearDown() {
        repository.deleteAll();
    }

//    @Test
//    public void testCanAddEmployee(){
//
//
//        assertThat(repository).isNotNull();
//        log.info("EmployeeResponse id is :: {}", shayto.getId());
//        assertThat(shayto.getId()).isNotNull();
//
//    }
//
//    @Test
//    public void testCanGetEmployee(){
//        EmployeeResponse savedEmployee = repository.findById(shayto.getId()).get();
//        assertThat(savedEmployee.getId()).isEqualTo(shayto.getId());
//    }

//    @Test
//    public void testCanDeleteEmployeeRecords(){
//        log.info("Id is :: {}", shayto.getId());
//        assertThat(shayto.getId()).isNotNull();
//
//        repository.deleteEmployeeById(shayto.getId());
//        log.info("Id is :: {}", shayto.getId());
//        assertThat(shayto.getId()).isNull();
//    }


}