package edu.students.settler.controller.payment.impl;

import edu.students.settler.controller.payment.PaymentController;
import edu.students.settler.controller.payment.dto.PaymentDetailsDTO;
import edu.students.settler.controller.payment.dto.PaymentResponseDTO;
import edu.students.settler.model.service.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
@AllArgsConstructor(onConstructor_ = @Autowired)
class PaymentControllerImpl implements PaymentController {

    private PaymentService paymentService;

    @Override
    @PostMapping("pay")
    public PaymentResponseDTO pay(@RequestBody PaymentDetailsDTO paymentDetails) {
        return paymentService.pay(paymentDetails);
    }
}
