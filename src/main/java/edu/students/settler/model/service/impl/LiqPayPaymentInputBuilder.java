package edu.students.settler.model.service.impl;

import edu.students.settler.controller.payment.dto.PaymentDetailsDTO;
import org.modelmapper.internal.bytebuddy.utility.RandomString;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Component
class LiqPayPaymentInputBuilder {

    static final String API_VERSION = "3";
    static final String UAH_CURRENCY = "UAH";
    static final String P2P_ACTION = "p2p";
    static final String PAYMENT_DESCRIPTION = "Payment for Dormitory.";
    static final String[] RECEIVER_CARD_NUMBERS = {"4242424242424242", "INCORRECT_CARD_NUMBER"};

    static final String PAYMENT_INPUT_ACTION = "action";
    static final String PAYMENT_INPUT_VERSION = "version";
    static final String PAYMENT_INPUT_CURRENCY = "currency";
    static final String PAYMENT_INPUT_ORDER_ID = "order_id";
    static final String PAYMENT_INPUT_RECEIVER_CARD = "receiver_card";
    static final String PAYMENT_INPUT_CARD = "card";
    static final String PAYMENT_INPUT_CARD_EXP_MONTH = "card_exp_month";
    static final String PAYMENT_INPUT_CARD_EXP_YEAR = "card_exp_year";
    static final String PAYMENT_INPUT_CARD_CVV = "card_cvv";
    static final String PAYMENT_INPUT_AMOUNT = "amount";
    static final String PAYMENT_INPUT_PUBLIC_KEY = "public_key";
    static final String PAYMENT_INPUT_DESCRIPTION = "description";

    Map<String, String> build(PaymentDetailsDTO paymentDetails, String liqPayPublicKey) {
        Map<String, String> params = new HashMap<>();
        params.put(PAYMENT_INPUT_ACTION, P2P_ACTION);
        params.put(PAYMENT_INPUT_VERSION, API_VERSION);
        params.put(PAYMENT_INPUT_CURRENCY, UAH_CURRENCY);
        params.put(PAYMENT_INPUT_DESCRIPTION, PAYMENT_DESCRIPTION);
        params.put(PAYMENT_INPUT_ORDER_ID, generateOrderId());
        params.put(PAYMENT_INPUT_PUBLIC_KEY, liqPayPublicKey);
        params.put(PAYMENT_INPUT_RECEIVER_CARD, getReceiverCardNumber());
        params.put(PAYMENT_INPUT_CARD, paymentDetails.getCreditCard().getNumber());
        params.put(PAYMENT_INPUT_CARD_EXP_MONTH, paymentDetails.getCreditCard().getExpirationMonth());
        params.put(PAYMENT_INPUT_CARD_EXP_YEAR, paymentDetails.getCreditCard().getExpirationYear());
        params.put(PAYMENT_INPUT_CARD_CVV, paymentDetails.getCreditCard().getCvv());
        params.put(PAYMENT_INPUT_AMOUNT, String.valueOf(paymentDetails.getPrice()));

        return params;
    }

    private String generateOrderId() {
        return RandomString.make(16);
    }

    private String getReceiverCardNumber() {
        return RECEIVER_CARD_NUMBERS[new Random().nextInt(2)];
    }
}
