package edu.students.settler.controller.payment;

import edu.students.settler.controller.payment.dto.PaymentDetailsDTO;
import edu.students.settler.controller.payment.dto.PaymentResponseDto;

public interface PaymentController {

    PaymentResponseDto pay(PaymentDetailsDTO paymentDetails);
}
