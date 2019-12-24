package edu.students.settler.controller.payment.impl;

import edu.students.settler.controller.payment.PaymentController;
import edu.students.settler.controller.payment.dto.PaymentDetailsDTO;
import edu.students.settler.controller.payment.dto.PaymentResponseDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentControllerImpl implements PaymentController {

    static final String PAYMENT_RESPONSE_MESSAGE = "You have successfully paid for Dormitory.";

    @Override
    @PostMapping("pay")
    public PaymentResponseDto pay(@RequestBody PaymentDetailsDTO paymentDetails) {
        return formPaymentResponse();
    }

    private PaymentResponseDto formPaymentResponse() {
        PaymentResponseDto response = new PaymentResponseDto();
        response.setMessage(PAYMENT_RESPONSE_MESSAGE);

        return response;
    }
}
