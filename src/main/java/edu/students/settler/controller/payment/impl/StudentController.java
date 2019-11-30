package edu.students.settler.controller.payment.impl;

import edu.students.settler.controller.payment.dto.StudentDTO;
import edu.students.settler.model.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping()
    public List<StudentDTO> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping()
    public StudentDTO createStudent(@RequestBody StudentDTO student) {
        return studentService.createStudent(student);
    }

}
