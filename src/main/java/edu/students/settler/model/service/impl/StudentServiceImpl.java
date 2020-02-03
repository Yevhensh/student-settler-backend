package edu.students.settler.model.service.impl;

import edu.students.settler.controller.student.dto.StudentDTO;
import edu.students.settler.controller.student.dto.ValidateDTO;
import edu.students.settler.model.entity.student.Student;
import edu.students.settler.model.repository.StudentRepository;
import edu.students.settler.model.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
class StudentServiceImpl implements StudentService {
    private static final String STUDENT_NOT_FOUND_MESSAGE = "Student with following fields is not found. Please, check your input.";

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public ValidateDTO validateStudentExistence(StudentDTO student) {
        return findStudent(student)
                .map((s) -> formSuccessfulValidateDTO())
                .orElseGet(() -> formFailedValidateDTO(student));
    }

    private Optional<Student> findStudent(StudentDTO student) {
        return studentRepository.findByNameAndSurnameAndStudentNumber(student.getName(), student.getSurname(), student.getStudentNumber());
    }

    private ValidateDTO formSuccessfulValidateDTO() {
        return ValidateDTO.successful();
    }

    private ValidateDTO formFailedValidateDTO(StudentDTO student) {
        log.info(STUDENT_NOT_FOUND_MESSAGE);
        return ValidateDTO.failed(STUDENT_NOT_FOUND_MESSAGE);
    }
}
