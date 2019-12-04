package edu.students.settler.controller.payment.impl;

import edu.students.settler.controller.payment.StudentController;
import edu.students.settler.controller.payment.dto.StudentDTO;
import edu.students.settler.controller.payment.dto.ValidateDTO;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class StudentControllerImplTest {

    @Mock
    private StudentController studentController;

    @Test
    void validateStudent() {
        StudentDTO sampleStudent = formStudentDTO();
        when(studentController.validateStudent(sampleStudent)).then()
    }

    private StudentDTO formStudentDTO() {
        return new StudentDTO(1L, "Petro", "Vasilovich", "u26123412141");
    }

    private ValidateDTO<StudentDTO> formSuccessValidateDTO(StudentDTO student) {
        return ValidateDTO.successful(student);
    }

    private ValidateDTO<StudentDTO> formFailedValidateDTO()
}