package edu.students.settler.controller.payment.dto;

import lombok.Data;

@Data
public class CreditCardDTO {

    private String number;
    private String ownerName;
    private String expirationMonth;
    private String expirationYear;
    private String cvv;
}
