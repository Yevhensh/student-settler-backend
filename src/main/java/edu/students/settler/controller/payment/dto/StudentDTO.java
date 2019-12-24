package edu.students.settler.controller.payment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentDTO {
    private long id;
    private String name;
    private String surname;
    private String studentNumber;

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", studentNumber='" + studentNumber + '\'';
    }
}