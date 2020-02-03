package edu.students.settler;

import edu.students.settler.controller.student.dto.StudentDTO;
import edu.students.settler.controller.student.dto.ValidateDTO;
import edu.students.settler.model.entity.student.Student;

public interface StudentHelper {
    class StudentConstants {
        public static final Long STUDENT_ID = 1L;
        public static final String STUDENT_NAME = "Petro";
        public static final String STUDENT_SURNAME = "Vasilovich";
        public static final String STUDENT_NUMBER = "u26123412141";
    }


    default ValidateDTO formFailedValidateDTO(StudentDTO student) {
        return ValidateDTO.failed("Student with following fields is not found. Please, check your input.");
    }

    default StudentDTO formStubStudentDTO() {
        return new StudentDTO(StudentConstants.STUDENT_ID, StudentConstants.STUDENT_NAME, StudentConstants.STUDENT_SURNAME, StudentConstants.STUDENT_NUMBER);
    }

    default Student formStubStudent() {
        return new Student(StudentConstants.STUDENT_ID, StudentConstants.STUDENT_NAME, StudentConstants.STUDENT_SURNAME, StudentConstants.STUDENT_NUMBER);
    }
}
