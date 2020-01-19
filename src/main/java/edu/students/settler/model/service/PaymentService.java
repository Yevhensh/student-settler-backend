package edu.students.settler.model.service;

import edu.students.settler.controller.payment.dto.PaymentDetailsDTO;
import edu.students.settler.controller.payment.dto.PaymentResponseDTO;

public interface PaymentService {

    PaymentResponseDTO pay(PaymentDetailsDTO paymentDetails);
}
