package edu.students.settler.model.service.mapper;

import edu.students.settler.controller.payment.dto.DormitoryDto;
import edu.students.settler.controller.payment.dto.RoomDto;
import edu.students.settler.controller.payment.dto.StudentDto;
import edu.students.settler.model.entity.Dormitory;
import edu.students.settler.model.entity.Room;
import edu.students.settler.model.entity.Student;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class EntityMapper {
    private final ModelMapper modelMapper;

    public EntityMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Student mapToStudent(StudentDto studentDTO) {
        return modelMapper.map(studentDTO, Student.class);
    }

    public StudentDto mapToStudentDto(Student student) {
        return modelMapper.map(student, StudentDto.class);
    }

    public Dormitory mapToDormitory(DormitoryDto dormitoryDto) {
        return modelMapper.map(dormitoryDto, Dormitory.class);
    }

    public DormitoryDto mapToDormitoryDto(Dormitory dormitory) {
        return modelMapper.map(dormitory, DormitoryDto.class);
    }

    public Room mapToRoom(RoomDto roomDto) {
        return modelMapper.map(roomDto, Room.class);
    }

    public RoomDto mapToRoomDto(Room room) {
        return modelMapper.map(room, RoomDto.class);
    }


}
