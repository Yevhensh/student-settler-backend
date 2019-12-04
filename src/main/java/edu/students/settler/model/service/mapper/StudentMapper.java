package edu.students.settler.model.service.mapper;

import edu.students.settler.controller.payment.dto.StudentDTO;
import edu.students.settler.model.entity.Student;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper implements EntityMapper<Student, StudentDTO> {

    private final ModelMapper modelMapper;

    public StudentMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public StudentDTO mapToStudentDto(Student student) {
        return modelMapper.map(student, StudentDTO.class);
    }
}