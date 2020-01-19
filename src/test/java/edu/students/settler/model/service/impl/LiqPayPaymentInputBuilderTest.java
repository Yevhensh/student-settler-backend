package edu.students.settler.model.service.impl;

import edu.students.settler.controller.payment.dto.CreditCardDTO;
import edu.students.settler.controller.payment.dto.PaymentDetailsDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class LiqPayPaymentInputBuilderTest {

    private static final String CARD_NUMBER = "CARD_NUMBER";
    private static final String CARD_EXPIRATION_MONTH = "CARD_EXPIRATION_MONTH";
    private static final String CARD_EXPIRATION_YEAR = "CARD_EXPIRATION_YEAR";
    private static final String CARD_CVV = "CARD_CVC";
    private static final double PAYMENT_MONEY_AMOUNT = 1.0;

    private static final String LIQ_PAY_PUBLIC_KEY = "LIQ_PAY_PUBLIC_KEY";

    private static final String P2P_ACTION = LiqPayPaymentInputBuilder.P2P_ACTION;
    private static final String API_VERSION = LiqPayPaymentInputBuilder.API_VERSION;
    private static final String UAH_CURRENCY = LiqPayPaymentInputBuilder.UAH_CURRENCY;
    private static final String PAYMENT_DESCRIPTION = LiqPayPaymentInputBuilder.PAYMENT_DESCRIPTION;
    private static final Set<String> RECEIVER_CARD_NUMBERS = Set.of(LiqPayPaymentInputBuilder.RECEIVER_CARD_NUMBERS);

    private static final String PAYMENT_INPUT_ACTION = LiqPayPaymentInputBuilder.PAYMENT_INPUT_ACTION;
    private static final String PAYMENT_INPUT_VERSION = LiqPayPaymentInputBuilder.PAYMENT_INPUT_VERSION;
    private static final String PAYMENT_INPUT_CURRENCY = LiqPayPaymentInputBuilder.PAYMENT_INPUT_CURRENCY;
    private static final String PAYMENT_INPUT_ORDER_ID = LiqPayPaymentInputBuilder.PAYMENT_INPUT_ORDER_ID;
    private static final String PAYMENT_INPUT_AMOUNT = LiqPayPaymentInputBuilder.PAYMENT_INPUT_AMOUNT;
    private static final String PAYMENT_INPUT_PUBLIC_KEY = LiqPayPaymentInputBuilder.PAYMENT_INPUT_PUBLIC_KEY;
    private static final String PAYMENT_INPUT_DESCRIPTION = LiqPayPaymentInputBuilder.PAYMENT_INPUT_DESCRIPTION;
    private static final String PAYMENT_INPUT_RECEIVER_CARD = LiqPayPaymentInputBuilder.PAYMENT_INPUT_RECEIVER_CARD;
    private static final String PAYMENT_INPUT_CARD = LiqPayPaymentInputBuilder.PAYMENT_INPUT_CARD;
    private static final String PAYMENT_INPUT_CARD_EXP_MONTH = LiqPayPaymentInputBuilder.PAYMENT_INPUT_CARD_EXP_MONTH;
    private static final String PAYMENT_INPUT_CARD_EXP_YEAR = LiqPayPaymentInputBuilder.PAYMENT_INPUT_CARD_EXP_YEAR;
    private static final String PAYMENT_INPUT_CARD_CVV = LiqPayPaymentInputBuilder.PAYMENT_INPUT_CARD_CVV;

    private LiqPayPaymentInputBuilder underTest;

    @BeforeEach
    void setUp() {
        underTest = new LiqPayPaymentInputBuilder();
    }

    @Test
    public void testBuild() {
        CreditCardDTO creditCard = buildCreditCardDTO();
        PaymentDetailsDTO paymentDetails = buildPaymentDetailsDTO(creditCard);

        Map<String, String> result = underTest.build(paymentDetails, LIQ_PAY_PUBLIC_KEY);

        assertNotNull(result);
        assertEquals(result.get(PAYMENT_INPUT_ACTION), P2P_ACTION);
        assertEquals(result.get(PAYMENT_INPUT_VERSION), API_VERSION);
        assertEquals(result.get(PAYMENT_INPUT_CURRENCY), UAH_CURRENCY);
        assertEquals(result.get(PAYMENT_INPUT_DESCRIPTION), PAYMENT_DESCRIPTION);
        assertNotNull(result.get(PAYMENT_INPUT_ORDER_ID));
        assertEquals(result.get(PAYMENT_INPUT_PUBLIC_KEY), LIQ_PAY_PUBLIC_KEY);
        assertTrue(RECEIVER_CARD_NUMBERS.contains(result.get(PAYMENT_INPUT_RECEIVER_CARD)));
        assertEquals(result.get(PAYMENT_INPUT_CARD), CARD_NUMBER);
        assertEquals(result.get(PAYMENT_INPUT_CARD_EXP_MONTH), CARD_EXPIRATION_MONTH);
        assertEquals(result.get(PAYMENT_INPUT_CARD_EXP_YEAR), CARD_EXPIRATION_YEAR);
        assertEquals(result.get(PAYMENT_INPUT_CARD_CVV), CARD_CVV);
        assertEquals(result.get(PAYMENT_INPUT_AMOUNT), String.valueOf(PAYMENT_MONEY_AMOUNT));
    }

    private CreditCardDTO buildCreditCardDTO() {
        CreditCardDTO creditCard = new CreditCardDTO();
        creditCard.setNumber(CARD_NUMBER);
        creditCard.setExpirationMonth(CARD_EXPIRATION_MONTH);
        creditCard.setExpirationYear(CARD_EXPIRATION_YEAR);
        creditCard.setCvv(CARD_CVV);

        return creditCard;
    }

    private PaymentDetailsDTO buildPaymentDetailsDTO(CreditCardDTO creditCard) {
        PaymentDetailsDTO paymentDetails = new PaymentDetailsDTO();
        paymentDetails.setPrice(PAYMENT_MONEY_AMOUNT);
        paymentDetails.setCreditCard(creditCard);

        return paymentDetails;
    }
}