package edu.students.settler.model.service;

import edu.students.settler.controller.payment.dto.DormitoryDto;
import edu.students.settler.controller.payment.dto.RoomDto;
import edu.students.settler.model.entity.Dormitory;
import edu.students.settler.model.repository.DormitoryRepository;
import edu.students.settler.model.repository.RoomRepository;
import edu.students.settler.model.service.mapper.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DormitoryService {
    private final DormitoryRepository dormitoryRepository;

    private final EntityMapper entityMapper;

    @Autowired
    public DormitoryService(DormitoryRepository dormitoryRepository, EntityMapper entityMapper) {
        this.dormitoryRepository = dormitoryRepository;
        this.entityMapper = entityMapper;
    }

    public List<DormitoryDto> getDormitories() {
        return dormitoryRepository.findAll().stream().map(entityMapper::mapToDormitoryDto).collect(Collectors.toList());
    }

    public Optional<DormitoryDto> getDormitoryById(long id) {
        return dormitoryRepository.findById(id).map(entityMapper::mapToDormitoryDto);
    }

    public DormitoryDto createDormitory(DormitoryDto dormitoryDto) {
        Dormitory dormitory = dormitoryRepository.save(entityMapper.mapToDormitory(dormitoryDto));
        return entityMapper.mapToDormitoryDto(dormitory);
    }

    public DormitoryDto updateDormitory(DormitoryDto dormitoryDto) {
        dormitoryRepository.deleteById(dormitoryDto.getId());
        Dormitory dormitoryRes = dormitoryRepository.saveAndFlush(entityMapper.mapToDormitory(dormitoryDto));
        return entityMapper.mapToDormitoryDto(dormitoryRes);
    }

    public void deleteDormitory(long id) {
        dormitoryRepository.deleteById(id);
    }
}