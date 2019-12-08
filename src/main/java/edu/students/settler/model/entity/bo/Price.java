package edu.students.settler.model.entity.bo;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class Price {

    private double price;
}