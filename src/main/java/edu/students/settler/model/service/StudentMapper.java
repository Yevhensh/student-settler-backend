package edu.students.settler.model.service;

import edu.students.settler.controller.payment.dto.StudentDTO;
import edu.students.settler.model.entity.Student;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {
    private final ModelMapper modelMapper;

    public StudentMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Student mapToStudent(StudentDTO studentDTO) {
        return modelMapper.map(studentDTO, Student.class);
    }

    public StudentDTO mapToStudentDto(Student student) {
        return modelMapper.map(student, StudentDTO.class);
    }
}
