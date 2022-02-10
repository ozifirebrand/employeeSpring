package africa.semicolon.employeeProgram.data.repositories;

import africa.semicolon.employeeProgram.data.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    void deleteEmployeeById(Long id);

}
