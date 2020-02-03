package edu.students.settler.model.entity.dormitory;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class RoomSlot {
    private boolean isAvailable;
}