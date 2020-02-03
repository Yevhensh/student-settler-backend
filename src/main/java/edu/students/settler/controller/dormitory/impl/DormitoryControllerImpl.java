package edu.students.settler.controller.dormitory.impl;

import edu.students.settler.controller.dormitory.DormitoryController;
import edu.students.settler.model.entity.dormitory.Dormitory;
import edu.students.settler.model.entity.dormitory.Room;
import edu.students.settler.model.service.DormitoryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/dormitories")
@AllArgsConstructor(onConstructor_ = @Autowired)
class DormitoryControllerImpl implements DormitoryController {

    private DormitoryService dormitoryService;

    @Override
    @GetMapping
    public List<Dormitory> findAll() {
        return dormitoryService.findAll();
    }

    @Override
    @RequestMapping("/{dormitoryId}/rooms")
    public Set<Room> getDormitoryRooms(@PathVariable long dormitoryId) {
        return dormitoryService.findDormitoryRooms(dormitoryId);
    }
}
