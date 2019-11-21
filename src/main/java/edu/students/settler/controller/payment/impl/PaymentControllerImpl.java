package edu.students.settler.controller.payment.impl;

import edu.students.settler.controller.payment.PaymentController;
import edu.students.settler.controller.payment.dto.PaymentInfoDTO;
import edu.students.settler.controller.payment.dto.PaymentResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentControllerImpl implements PaymentController {

    @Override
    @PostMapping("pay")
    @ResponseStatus(HttpStatus.OK)
    public PaymentResponseDTO pay(PaymentInfoDTO paymentInfo) {
        return formPaymentResponse();
    }

    private PaymentResponseDTO formPaymentResponse() {
        PaymentResponseDTO response = new PaymentResponseDTO();
        response.setMessage("You have successfully paid for Dormitory.");

        return response;
    }
}
