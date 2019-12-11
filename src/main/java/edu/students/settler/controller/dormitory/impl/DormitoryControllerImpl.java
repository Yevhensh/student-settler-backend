package edu.students.settler.controller.dormitory.impl;

import edu.students.settler.controller.dormitory.DormitoryController;
import edu.students.settler.model.entity.Dormitory;
import edu.students.settler.service.DormitoryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
