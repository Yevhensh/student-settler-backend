package edu.students.settler.model.service;

import edu.students.settler.controller.payment.dto.StudentDTO;
import edu.students.settler.model.entity.Student;
import edu.students.settler.model.repository.impl.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    private final StudentMapper studentMapper;

    @Autowired
    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    public List<StudentDTO> getStudents() {
        List<Student> students = studentRepository.findAll();
        return students.stream().map(studentMapper::mapToStudentDto).collect(Collectors.toList());
    }

    public StudentDTO createStudent(StudentDTO studentDto) {
        Student student = studentMapper.mapToStudent(studentDto);
        Student studentRes = studentRepository.save(student);
        return studentMapper.mapToStudentDto(studentRes);
    }

    public Optional<StudentDTO> getStudent(long id) {
        return retrieveById(id).map(studentMapper::mapToStudentDto);
    }

    public StudentDTO updateStudent(StudentDTO studentDTO) {
        studentRepository.deleteById(studentDTO.getId());
        Student student = studentRepository.saveAndFlush(studentMapper.mapToStudent(studentDTO));
        return studentMapper.mapToStudentDto(student);
    }

    private Optional<Student> retrieveById(long id) {
        return studentRepository.findById(id);
    }
}