package edu.students.settler.model.service.impl;

import edu.students.settler.model.entity.dormitory.Dormitory;
import edu.students.settler.model.entity.dormitory.Room;
import edu.students.settler.model.repository.DormitoryRepository;
import edu.students.settler.model.service.DormitoryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
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
