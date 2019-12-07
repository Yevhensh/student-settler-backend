package edu.students.settler.model.service.impl;

import edu.students.settler.controller.payment.dto.StudentDTO;
import edu.students.settler.controller.payment.dto.ValidateDTO;
import edu.students.settler.model.entity.Student;
import edu.students.settler.model.repository.StudentRepository;
import edu.students.settler.model.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.Optional;

@Slf4j
@Service
public class StudentServiceImpl implements StudentService {

    private static final String STUDENT_NOT_FOUND_MESSAGE = "Student with following fields not found: {0}";

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
        String failMessage = MessageFormat.format(STUDENT_NOT_FOUND_MESSAGE, student.toString());
        log.info(failMessage);
        return ValidateDTO.failed(failMessage);
    }
}
