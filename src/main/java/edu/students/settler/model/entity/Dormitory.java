package edu.students.settler.model.entity;

import edu.students.settler.model.entity.bo.Price;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "dormitory")
public class Dormitory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "dormitory_id")
    private long id;

    @Column(name = "number")
    private int number;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "dormitory_id")
    private Set<Room> rooms;

    @Embedded
    private Price pricePerMonth;
}