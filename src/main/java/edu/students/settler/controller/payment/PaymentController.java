package edu.students.settler.controller.payment;

import edu.students.settler.controller.payment.dto.PaymentDetailsDTO;
import edu.students.settler.controller.payment.dto.PaymentResponseDTO;

public interface PaymentController {

    PaymentResponseDTO pay(PaymentDetailsDTO paymentDetails);
}
