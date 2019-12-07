package edu.students.settler.controller.payment;

import edu.students.settler.controller.payment.dto.StudentDTO;
import edu.students.settler.controller.payment.dto.ValidateDTO;

public interface StudentController {
    ValidateDTO validateStudentExistence(StudentDTO studentDto);
}
