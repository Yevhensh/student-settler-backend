package edu.students.settler.controller.payment.dto;

import lombok.Data;

@Data
public class PaymentInfoDto {
    private String name;
    private String surName;
    private String studentNumber;
    private int dormitoryNumber;
    private String room;
}
