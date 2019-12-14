package edu.students.settler.service.impl;

import edu.students.settler.model.entity.Dormitory;
import edu.students.settler.model.entity.Room;
import edu.students.settler.model.repository.DormitoryRepository;
import edu.students.settler.service.DormitoryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@Component
@AllArgsConstructor(onConstructor_ = @Autowired)
class DormitoryServiceImpl implements DormitoryService {

    private DormitoryRepository dormitoryRepository;

    @Override
    public List<Dormitory> findAll() {
        return dormitoryRepository.findAll();
    }

    @Override
    public Set<Room> findDormitoryRooms(long dormitoryId) {
        return dormitoryRepository.findById(dormitoryId).map(Dormitory::getRooms).orElse(Collections.emptySet());
    }
}
