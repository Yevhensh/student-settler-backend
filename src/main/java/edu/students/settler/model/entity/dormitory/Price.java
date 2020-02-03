package edu.students.settler.model.entity.dormitory;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class Price {

    private double price;
}