package edu.students.settler.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "dormitory_id")
    @JsonIgnore
    private Set<Room> rooms;

    @Embedded
    private Price pricePerMonth;
}