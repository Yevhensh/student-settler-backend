package edu.students.settler.controller.payment.impl;

import edu.students.settler.controller.payment.PaymentController;
import edu.students.settler.controller.payment.dto.PaymentInfoDTO;
import edu.students.settler.controller.payment.dto.PaymentResponseDTO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentControllerImpl implements PaymentController {

    static final String PAYMENT_RESPONSE_MESSAGE = "You have successfully paid for Dormitory.";

    @Override
    @PostMapping("pay")
    @CrossOrigin(origins = "http://localhost:3000")
    public PaymentResponseDTO pay(PaymentInfoDTO paymentInfo) {
        return formPaymentResponse();
    }

    private PaymentResponseDTO formPaymentResponse() {
        PaymentResponseDTO response = new PaymentResponseDTO();
        response.setMessage(PAYMENT_RESPONSE_MESSAGE);
        return response;
    }
}
