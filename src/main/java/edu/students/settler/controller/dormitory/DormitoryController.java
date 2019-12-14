package edu.students.settler.controller.dormitory;

import edu.students.settler.model.entity.Dormitory;
import edu.students.settler.model.entity.Room;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Set;

public interface DormitoryController {

    List<Dormitory> findAll();

    Set<Room> getDormitoryRooms(long dormitoryId);
}
