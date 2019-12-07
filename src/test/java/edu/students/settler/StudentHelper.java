package edu.students.settler;

import edu.students.settler.controller.payment.dto.StudentDTO;
import edu.students.settler.controller.payment.dto.ValidateDTO;
import edu.students.settler.model.entity.Student;

import java.text.MessageFormat;

public interface StudentHelper {

    default ValidateDTO formFailedValidateDTO(StudentDTO student) {
        return ValidateDTO.failed(MessageFormat.format("Student with following fields not found: {0}", student));
    }

    default StudentDTO formStubStudentDTO() {
        return new StudentDTO(1L, "Petro", "Vasilovich", "u26123412141");
    }

    default Student formStubStudent() {
        return new Student(1L, "Petro", "Vasilovich", "u26123412141");
    }
}
