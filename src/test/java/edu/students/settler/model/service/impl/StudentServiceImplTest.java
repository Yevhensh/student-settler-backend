package edu.students.settler.model.service.impl;

import edu.students.settler.StudentHelper;
import edu.students.settler.controller.payment.dto.StudentDTO;
import edu.students.settler.controller.payment.dto.ValidateDTO;
import edu.students.settler.model.entity.Student;
import edu.students.settler.model.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudentServiceImplTest implements StudentHelper {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentServiceImpl studentService;

    @Test
    void validateSuccessfulStudentExistence() {
        StudentDTO inputStudentDTO = formStubStudentDTO();
        Student resStudent = formStubStudent();
        Optional<Student> resStudentOpt = Optional.of(resStudent);

        when(studentRepository.findByNameAndSurnameAndStudentNumber(StudentConstants.STUDENT_NAME, StudentConstants.STUDENT_SURNAME,
                StudentConstants.STUDENT_NUMBER)).thenReturn(resStudentOpt);

        ValidateDTO expected = ValidateDTO.successful();
        ValidateDTO actual = studentService.validateStudentExistence(inputStudentDTO);

        verify(studentRepository).findByNameAndSurnameAndStudentNumber(StudentConstants.STUDENT_NAME, StudentConstants.STUDENT_SURNAME,
                StudentConstants.STUDENT_NUMBER);
        assertEquals(expected, actual, "Student should be found");
    }

    @Test
    void validateNotFoundStudentExistence() {
        StudentDTO inputStudentDTO = formStubStudentDTO();

        when(studentRepository.findByNameAndSurnameAndStudentNumber(StudentConstants.STUDENT_NAME, StudentConstants.STUDENT_SURNAME,
                StudentConstants.STUDENT_NUMBER)).thenReturn(Optional.empty());

        ValidateDTO expected = formFailedValidateDTO(inputStudentDTO);
        ValidateDTO actual = studentService.validateStudentExistence(inputStudentDTO);

        verify(studentRepository).findByNameAndSurnameAndStudentNumber(StudentConstants.STUDENT_NAME, StudentConstants.STUDENT_SURNAME,
                StudentConstants.STUDENT_NUMBER);
        assertEquals(expected, actual, "Student shouldn't be found");
    }
}