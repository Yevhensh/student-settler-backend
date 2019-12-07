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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceImplTest implements StudentHelper {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentServiceImpl studentService;

    @Test
    public void validateSuccessfulStudentExistence() {
        StudentDTO inputStudentDTO = formStubStudentDTO();
        Student resStudent = formStubStudent();
        Optional<Student> resStudentOpt = Optional.of(resStudent);

        when(studentRepository.findByNameAndSurnameAndStudentNumber("Petro", "Vasilovich", "u26123412141")).thenReturn(resStudentOpt);

        ValidateDTO expected = ValidateDTO.successful();
        ValidateDTO actual = studentService.validateStudentExistence(inputStudentDTO);

        verify(studentRepository, atMostOnce()).findByNameAndSurnameAndStudentNumber(anyString(), anyString(), anyString());
        assertEquals(expected, actual, "Student should be found");
    }

    @Test
    public void validateNotFoundStudentExistence() {
        StudentDTO inputStudentDTO = formStubStudentDTO();

        when(studentRepository.findByNameAndSurnameAndStudentNumber("Petro", "Vasilovich", "u26123412141")).thenReturn(Optional.empty());

        ValidateDTO expected = formFailedValidateDTO(inputStudentDTO);
        ValidateDTO actual = studentService.validateStudentExistence(inputStudentDTO);

        verify(studentRepository, atMostOnce()).findByNameAndSurnameAndStudentNumber(anyString(), anyString(), anyString());
        assertEquals(expected, actual, "Student shouldn't be found");
    }
}