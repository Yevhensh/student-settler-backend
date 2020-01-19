package edu.students.settler.model.service.impl;

import com.liqpay.LiqPay;
import edu.students.settler.configuration.LiqPayWrapper;
import edu.students.settler.controller.payment.dto.PaymentDetailsDTO;
import edu.students.settler.controller.payment.dto.PaymentResponseDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static java.util.Collections.emptyMap;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LiqPayPaymentServiceTest {

    private static final String PAYMENT_REQUEST_URL = LiqPayPaymentService.PAYMENT_REQUEST_URL;
    private static final String PAYMENT_SUCCESS_STATUS = LiqPayPaymentService.PAYMENT_SUCCESS_STATUS;
    private static final String PAYMENT_SUCCESS_MESSAGE = LiqPayPaymentService.PAYMENT_SUCCESS_MESSAGE;
    private static final String PAYMENT_EXCEPTION_MESSAGE = LiqPayPaymentService.PAYMENT_EXCEPTION_MESSAGE;

    private static final String PAYMENT_OUTPUT_STATUS = LiqPayPaymentService.PAYMENT_OUTPUT_STATUS;
    private static final String PAYMENT_OUTPUT_ERR_DESCRIPTION = LiqPayPaymentService.PAYMENT_OUTPUT_ERR_DESCRIPTION;

    @InjectMocks
    private LiqPayPaymentService underTest;
    @Mock
    private LiqPayWrapper liqPayWrapper;
    @Mock
    private LiqPayPaymentInputBuilder paymentInputBuilder;

    @Mock
    private LiqPay liqPay;

    @Test
    public void testPayIfExceptionOccurs() throws Exception {
        PaymentDetailsDTO paymentDetails = new PaymentDetailsDTO();

        PaymentResponseDTO expectedResponse = PaymentResponseDTO.failure(PAYMENT_EXCEPTION_MESSAGE);

        when(liqPayWrapper.getPublicKey()).thenReturn(null);
        when(paymentInputBuilder.build(eq(paymentDetails), isNull())).thenReturn(emptyMap());
        when(liqPayWrapper.getLiqPay()).thenReturn(liqPay);
        when(liqPay.api(PAYMENT_REQUEST_URL, emptyMap())).thenThrow(Exception.class);

        PaymentResponseDTO result = underTest.pay(paymentDetails);

        verify(liqPayWrapper).getPublicKey();
        verify(paymentInputBuilder).build(eq(paymentDetails), isNull());
        verify(liqPayWrapper).getLiqPay();
        verify(liqPay).api(PAYMENT_REQUEST_URL, emptyMap());
        assertEquals(expectedResponse, result);
    }

    @Test
    public void testPayIfPaymentFails() throws Exception {
        final String PAYMENT_ERROR_STATUS = "PAYMENT_ERROR_STATUS";
        final String PAYMENT_ERROR_DESCRIPTION = "PAYMENT_ERROR_DESCRIPTION";

        PaymentDetailsDTO paymentDetails = new PaymentDetailsDTO();
        Map<String, Object> paymentResponse = buildPaymentResponse(PAYMENT_ERROR_STATUS, PAYMENT_ERROR_DESCRIPTION);

        PaymentResponseDTO expectedResponse = PaymentResponseDTO.failure(PAYMENT_ERROR_DESCRIPTION);

        when(liqPayWrapper.getPublicKey()).thenReturn(null);
        when(paymentInputBuilder.build(eq(paymentDetails), isNull())).thenReturn(emptyMap());
        when(liqPayWrapper.getLiqPay()).thenReturn(liqPay);
        when(liqPay.api(PAYMENT_REQUEST_URL, emptyMap())).thenReturn(paymentResponse);

        PaymentResponseDTO result = underTest.pay(paymentDetails);

        verify(liqPayWrapper).getPublicKey();
        verify(paymentInputBuilder).build(eq(paymentDetails), isNull());
        verify(liqPayWrapper).getLiqPay();
        verify(liqPay).api(PAYMENT_REQUEST_URL, emptyMap());
        assertEquals(expectedResponse, result);
    }

    @Test
    public void testPayIfPaymentSuccessful() throws Exception {
        PaymentDetailsDTO paymentDetails = new PaymentDetailsDTO();
        Map<String, Object> paymentResponse = buildPaymentResponse(PAYMENT_SUCCESS_STATUS, null);

        PaymentResponseDTO expectedResponse = PaymentResponseDTO.success(PAYMENT_SUCCESS_MESSAGE);

        when(liqPayWrapper.getPublicKey()).thenReturn(null);
        when(paymentInputBuilder.build(eq(paymentDetails), isNull())).thenReturn(emptyMap());
        when(liqPayWrapper.getLiqPay()).thenReturn(liqPay);
        when(liqPay.api(PAYMENT_REQUEST_URL, emptyMap())).thenReturn(paymentResponse);

        PaymentResponseDTO result = underTest.pay(paymentDetails);

        verify(liqPayWrapper).getPublicKey();
        verify(paymentInputBuilder).build(eq(paymentDetails), isNull());
        verify(liqPayWrapper).getLiqPay();
        verify(liqPay).api(PAYMENT_REQUEST_URL, emptyMap());
        assertEquals(expectedResponse, result);
    }

    private Map<String, Object> buildPaymentResponse(String status, String errorDescription) {
        Map<String, Object> paymentResponse = new HashMap<>();
        paymentResponse.put(PAYMENT_OUTPUT_STATUS, status);
        paymentResponse.put(PAYMENT_OUTPUT_ERR_DESCRIPTION, errorDescription);

        return paymentResponse;
    }
}