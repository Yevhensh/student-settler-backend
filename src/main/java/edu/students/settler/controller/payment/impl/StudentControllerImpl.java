package edu.students.settler.controller.payment.impl;

import edu.students.settler.controller.payment.StudentController;
import edu.students.settler.controller.payment.dto.StudentDTO;
import edu.students.settler.controller.payment.dto.ValidateDTO;
import edu.students.settler.model.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentControllerImpl implements StudentController {

    private StudentService studentService;

    @Autowired
    public StudentControllerImpl(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("validate")
    public ValidateDTO validateStudentExistence(@RequestBody StudentDTO studentDto) {
        return studentService.validateStudentExistence(studentDto);
    }
}
