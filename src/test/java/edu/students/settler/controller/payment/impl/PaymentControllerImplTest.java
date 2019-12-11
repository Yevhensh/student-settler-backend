package edu.students.settler.controller.payment.impl;

import edu.students.settler.controller.payment.dto.PaymentResponseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PaymentControllerImplTest {

    private static final String PAYMENT_RESPONSE_MESSAGE = PaymentControllerImpl.PAYMENT_RESPONSE_MESSAGE;

    private PaymentControllerImpl underTest;

    @BeforeEach
    void setUp() {
        underTest = new PaymentControllerImpl();
    }

    @Test
    void testPay() {
        PaymentResponseDto expectedResponse = buildPaymentResponseDTO();

        PaymentResponseDto result = underTest.pay(null);

        assertEquals(result, expectedResponse);
    }

    private PaymentResponseDto buildPaymentResponseDTO() {
        PaymentResponseDto response = new PaymentResponseDto();
        response.setMessage(PAYMENT_RESPONSE_MESSAGE);

        return response;
    }
}
