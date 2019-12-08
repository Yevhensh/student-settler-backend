package edu.students.settler;

import edu.students.settler.controller.payment.dto.StudentDTO;
import edu.students.settler.controller.payment.dto.ValidateDTO;
import edu.students.settler.model.entity.Student;

import java.text.MessageFormat;

public interface StudentHelper {
    class StudentConstants {
        public static final Long STUDENT_ID = 1L;
        public static final String STUDENT_NAME = "Petro";
        public static final String STUDENT_SURNAME = "Vasilovich";
        public static final String STUDENT_NUMBER = "u26123412141";
    }


    default ValidateDTO formFailedValidateDTO(StudentDTO student) {
        return ValidateDTO.failed(MessageFormat.format("Student with following fields not found: {0}", student));
    }

    default StudentDTO formStubStudentDTO() {
        return new StudentDTO(StudentConstants.STUDENT_ID, StudentConstants.STUDENT_NAME, StudentConstants.STUDENT_SURNAME, StudentConstants.STUDENT_NUMBER);
    }

    default Student formStubStudent() {
        return new Student(StudentConstants.STUDENT_ID, StudentConstants.STUDENT_NAME, StudentConstants.STUDENT_SURNAME, StudentConstants.STUDENT_NUMBER);
    }
}
