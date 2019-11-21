package edu.students.settler.controller.payment;

import edu.students.settler.controller.payment.dto.PaymentInfoDTO;
import edu.students.settler.controller.payment.dto.PaymentResponseDTO;

public interface PaymentController {

    PaymentResponseDTO pay(PaymentInfoDTO paymentInfo);
}
