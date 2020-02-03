package edu.students.settler.controller.student.impl;

import edu.students.settler.StudentHelper;
import edu.students.settler.controller.student.dto.StudentDTO;
import edu.students.settler.controller.student.dto.ValidateDTO;
import edu.students.settler.model.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudentControllerImplTest implements StudentHelper {

    @Mock
    private StudentService studentService;

    @InjectMocks
    private StudentControllerImpl studentController;

    @Test
    void validateSuccesssfulStudent() {
        StudentDTO sampleStudent = formStubStudentDTO();
        ValidateDTO validateResult = ValidateDTO.successful();

        when(studentService.validateStudentExistence(sampleStudent)).thenReturn(validateResult);

        ValidateDTO actual = studentController.validateStudentExistence(sampleStudent);

        verify(studentService).validateStudentExistence(sampleStudent);
        assertEquals(validateResult, actual, "Successful ValidateDTO must be returned");
    }

    @Test
    void validateFailedStudent() {
        StudentDTO sampleStudent = formStubStudentDTO();
        ValidateDTO validateResult = formFailedValidateDTO(sampleStudent);

        when(studentService.validateStudentExistence(sampleStudent)).thenReturn(validateResult);

        ValidateDTO actual = studentController.validateStudentExistence(sampleStudent);

        verify(studentService).validateStudentExistence(sampleStudent);
        assertEquals(validateResult, actual, "Failed ValidateDTO must be returned");
    }
}