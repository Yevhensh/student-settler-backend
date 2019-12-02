package edu.students.settler.model.entity.bo;

import lombok.Data;

import javax.persistence.*;

@Data
@Embeddable
public class Price {

    private String price;
}