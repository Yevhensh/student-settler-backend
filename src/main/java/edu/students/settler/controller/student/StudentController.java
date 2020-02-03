package edu.students.settler.controller.student;

import edu.students.settler.controller.student.dto.StudentDTO;
import edu.students.settler.controller.student.dto.ValidateDTO;

public interface StudentController {
    ValidateDTO validateStudentExistence(StudentDTO studentDto);
}
