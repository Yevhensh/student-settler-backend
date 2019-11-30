package edu.students.settler.model.entity;

import edu.students.settler.model.entity.bo.RoomSlot;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "number")
    private String number;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "room_slots", joinColumns = @JoinColumn(name = "room_id"))
    public List<RoomSlot> slots;
}