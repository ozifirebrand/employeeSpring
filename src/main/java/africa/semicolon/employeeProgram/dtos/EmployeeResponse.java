package africa.semicolon.employeeProgram.dtos;

import lombok.Data;

@Data
public class EmployeeResponse {
    private Long id;
    private String firstName;
    private String jobDescription;
}
