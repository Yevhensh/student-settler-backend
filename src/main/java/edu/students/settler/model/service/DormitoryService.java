package edu.students.settler.model.service;

import edu.students.settler.model.entity.dormitory.Dormitory;
import edu.students.settler.model.entity.dormitory.Room;

import java.util.List;
import java.util.Set;

public interface DormitoryService {

    List<Dormitory> findAll();

    Set<Room> findDormitoryRooms(long dormitoryId);
}
