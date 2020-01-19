package edu.students.settler.controller.payment.dto;

import lombok.Data;

@Data
public class PaymentDetailsDTO {

    private String studentNumber;
    private double price;
    private CreditCardDTO creditCard;
}
