package edu.students.settler.model.repository.impl;

import edu.students.settler.model.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
}