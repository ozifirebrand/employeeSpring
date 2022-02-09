package africa.semicolon.employeeProgram.data.repositories;

import africa.semicolon.employeeProgram.data.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
