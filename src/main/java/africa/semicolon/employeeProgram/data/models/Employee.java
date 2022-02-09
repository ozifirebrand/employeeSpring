package africa.semicolon.employeeProgram.data.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String firstName;
    private String lastName;
    private String jobDescription;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
