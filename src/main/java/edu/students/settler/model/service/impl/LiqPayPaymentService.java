package edu.students.settler.model.service.impl;

import edu.students.settler.configuration.LiqPayWrapper;
import edu.students.settler.controller.payment.dto.PaymentDetailsDTO;
import edu.students.settler.controller.payment.dto.PaymentResponseDTO;
import edu.students.settler.model.service.PaymentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

@Slf4j
@Service
@AllArgsConstructor(onConstructor_ = @Autowired)
class LiqPayPaymentService implements PaymentService {

    static final String PAYMENT_REQUEST_URL = "request";
    static final String PAYMENT_SUCCESS_STATUS = "success";
    static final String PAYMENT_SUCCESS_MESSAGE = "Payment is successful.";
    static final String PAYMENT_EXCEPTION_MESSAGE = "Some error occurs during payment. Please, try again later.";

    static final String PAYMENT_OUTPUT_STATUS = "status";
    static final String PAYMENT_OUTPUT_ERR_DESCRIPTION = "err_description";

    private LiqPayWrapper liqPayWrapper;
    private LiqPayPaymentInputBuilder paymentInputBuilder;

    @Override
    public PaymentResponseDTO pay(PaymentDetailsDTO paymentDetails) {
        try {
            Map<String, String> paymentInput = paymentInputBuilder.build(paymentDetails, liqPayWrapper.getPublicKey());
            return formPaymentResponse(liqPayWrapper.getLiqPay().api(PAYMENT_REQUEST_URL, paymentInput));
        } catch (Exception e) {
            log.error("Error during paying via LiqPay: " + e.getMessage(), e);
            return PaymentResponseDTO.failure(PAYMENT_EXCEPTION_MESSAGE);
        }
    }

    private PaymentResponseDTO formPaymentResponse(Map<String, Object> paymentResponse) {
        return isPaymentSuccessful(paymentResponse)
                ? PaymentResponseDTO.success(PAYMENT_SUCCESS_MESSAGE)
                : PaymentResponseDTO.failure(getErrorDescription(paymentResponse));
    }

    private boolean isPaymentSuccessful(Map<String, Object> result) {
        return Objects.equals(result.get(PAYMENT_OUTPUT_STATUS), PAYMENT_SUCCESS_STATUS);
    }

    private String getErrorDescription(Map<String, Object> paymentResponse) {
        return (String) paymentResponse.get(PAYMENT_OUTPUT_ERR_DESCRIPTION);
    }
}
