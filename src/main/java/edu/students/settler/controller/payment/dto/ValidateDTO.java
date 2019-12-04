package edu.students.settler.controller.payment.dto;

import lombok.Data;

@Data
public class ValidateDTO<T> {

    private T dto;
    private String failMessage;
    private boolean isSuccess;

    private ValidateDTO(T dto) {
        this.dto = dto;
        isSuccess = true;
    }

    private ValidateDTO(String failMessage) {
        this.failMessage = failMessage;
        this.isSuccess = false;
    }

    public static <U> ValidateDTO<U> successful(U dto) {
        return new ValidateDTO<>(dto);
    }

    public static <U> ValidateDTO<U> failed(String failMessage) {
        return new ValidateDTO<>(failMessage);
    }
}
