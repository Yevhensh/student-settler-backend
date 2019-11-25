package edu.students.settler.controller.payment.impl;

import edu.students.settler.controller.payment.dto.PaymentResponseDTO;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

class PaymentControllerImplTest {

    private static final String PAYMENT_RESPONSE_MESSAGE = PaymentControllerImpl.PAYMENT_RESPONSE_MESSAGE;

    private PaymentControllerImpl underTest;

    @BeforeMethod
    void setUp() {
        underTest = new PaymentControllerImpl();
    }

    @Test
    void testPay() {
        PaymentResponseDTO expectedResponse = buildPaymentResponseDTO();

        PaymentResponseDTO result = underTest.pay(null);

        assertEquals(result, expectedResponse);
    }

    private PaymentResponseDTO buildPaymentResponseDTO() {
        PaymentResponseDTO response = new PaymentResponseDTO();
        response.setMessage(PAYMENT_RESPONSE_MESSAGE);

        return response;
    }
}
