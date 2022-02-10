package africa.semicolon.employeeProgram.dtos;

import lombok.Data;

@Data
public class EmployeeRequest {
    private String firstName;
    private String lastName;
    private String jobDescription;
}
