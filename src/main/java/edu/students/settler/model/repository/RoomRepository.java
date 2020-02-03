package edu.students.settler.model.repository;

import edu.students.settler.model.entity.dormitory.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
}