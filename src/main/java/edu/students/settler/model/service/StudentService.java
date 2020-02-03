package edu.students.settler.model.service;


import edu.students.settler.controller.student.dto.StudentDTO;
import edu.students.settler.controller.student.dto.ValidateDTO;

public interface StudentService {

    ValidateDTO validateStudentExistence(StudentDTO student);

}
