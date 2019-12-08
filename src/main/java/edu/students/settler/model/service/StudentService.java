package edu.students.settler.model.service;


import edu.students.settler.controller.payment.dto.StudentDTO;
import edu.students.settler.controller.payment.dto.ValidateDTO;

public interface StudentService {

    ValidateDTO validateStudentExistence(StudentDTO student);

}
