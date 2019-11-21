package edu.students.settler.controller.payment.impl;

import edu.students.settler.controller.payment.dto.PaymentResponseDTO;
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
        PaymentResponseDTO expectedResponse = buildPaymentResponseDTO();

        PaymentResponseDTO result = underTest.pay(null);

        assertEquals(expectedResponse, result);
    }

    private PaymentResponseDTO buildPaymentResponseDTO() {
        PaymentResponseDTO response = new PaymentResponseDTO();
        response.setMessage(PAYMENT_RESPONSE_MESSAGE);

        return response;
    }
}