package edu.students.settler.model.service.impl;

import edu.students.settler.controller.payment.dto.StudentDTO;
import edu.students.settler.controller.payment.dto.ValidateDTO;
import edu.students.settler.model.entity.Student;
import edu.students.settler.model.repository.StudentRepository;
import edu.students.settler.model.service.StudentService;
import edu.students.settler.model.service.mapper.StudentMapper;
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

    private final StudentMapper studentMapper;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    @Override
    public ValidateDTO<StudentDTO> validateStudentExistence(StudentDTO student) {
        return findStudent(student)
                .map(this::formSuccessValidateDTO)
                .orElseGet(() -> formFailedValidateDTO(student));
    }

    private Optional<Student> findStudent(StudentDTO student) {
        return studentRepository.findByNameAndSurnameAndStudentNumber(student.getName(), student.getSurname(), student.getStudentNumber());
    }

    private ValidateDTO<StudentDTO> formSuccessValidateDTO(Student student) {
        return ValidateDTO.successful(studentMapper.mapToStudentDto(student));
    }

    private ValidateDTO<StudentDTO> formFailedValidateDTO(StudentDTO student) {
        String failMessage = MessageFormat.format(STUDENT_NOT_FOUND_MESSAGE, student.toString());
        log.info(failMessage);
        return ValidateDTO.failed(failMessage);
    }
}
