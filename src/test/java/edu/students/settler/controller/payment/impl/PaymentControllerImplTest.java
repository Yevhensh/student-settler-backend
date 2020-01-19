package edu.students.settler.controller.payment.impl;

import edu.students.settler.controller.payment.dto.PaymentResponseDTO;
import edu.students.settler.model.service.PaymentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PaymentControllerImplTest {

    @InjectMocks
    private PaymentControllerImpl underTest;
    @Mock
    private PaymentService paymentService;

    @Test
    void testPay() {
        when(paymentService.pay(isNull())).thenReturn(null);

        PaymentResponseDTO result = underTest.pay(null);

        verify(paymentService).pay(isNull());
        assertNull(result);
    }
}
