package edu.students.settler.controller.payment;

import edu.students.settler.controller.payment.dto.PaymentInfoDto;
import edu.students.settler.controller.payment.dto.PaymentResponseDto;

public interface PaymentController {

    PaymentResponseDto pay(PaymentInfoDto paymentInfo);
}
