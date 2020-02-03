package edu.students.settler.controller.dormitory;

import edu.students.settler.model.entity.dormitory.Dormitory;
import edu.students.settler.model.entity.dormitory.Room;

import java.util.List;
import java.util.Set;

public interface DormitoryController {

    List<Dormitory> findAll();

    Set<Room> getDormitoryRooms(long dormitoryId);
}
