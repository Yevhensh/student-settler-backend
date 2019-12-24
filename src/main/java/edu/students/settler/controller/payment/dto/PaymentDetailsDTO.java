package edu.students.settler.controller.payment.dto;

import lombok.Data;

@Data
public class PaymentDetailsDTO {

    private String studentNumber;
    private String cardNumber;
    private String ownerName;
    private String monthYear;
    private String cvc;
}
