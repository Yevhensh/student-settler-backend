package edu.students.settler.controller.payment.dto;

import lombok.Data;

@Data
public class ValidateDTO {

    private String failMessage;
    private boolean isSuccess;

    private ValidateDTO() {
        isSuccess = true;
    }

    private ValidateDTO(String failMessage) {
        this.failMessage = failMessage;
        this.isSuccess = false;
    }

    public static ValidateDTO successful() {
        return new ValidateDTO();
    }

    public static ValidateDTO failed(String failMessage) {
        return new ValidateDTO(failMessage);
    }
}
