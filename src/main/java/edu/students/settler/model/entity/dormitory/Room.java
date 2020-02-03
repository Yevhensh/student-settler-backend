package edu.students.settler.model.entity.dormitory;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "room_id")
    private long id;

    @Column(name = "title")
    private String title;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "room_slots", joinColumns = @JoinColumn(name = "room_id"))
    private List<RoomSlot> slots;
}