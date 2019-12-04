package edu.students.settler.controller.payment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentDTO {
    private long id;
    private String name;
    private String surname;
    private String studentNumber;
}