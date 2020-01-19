package edu.students.settler.controller.payment.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PaymentResponseDTO {

    private String message;
    private boolean isSuccessful;

    public static PaymentResponseDTO failure(String message) {
        return new PaymentResponseDTO(message, false);
    }

    public static PaymentResponseDTO success(String message) {
        return new PaymentResponseDTO(message, true);
    }
}