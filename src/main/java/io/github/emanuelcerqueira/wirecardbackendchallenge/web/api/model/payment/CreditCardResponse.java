package io.github.emanuelcerqueira.wirecardbackendchallenge.web.api.model.payment;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.emanuelcerqueira.wirecardbackendchallenge.core.model.CreditCardPayment;
import io.github.emanuelcerqueira.wirecardbackendchallenge.core.model.PaymentStatus;

public class CreditCardResponse {

    @JsonProperty("payment_status")
    private PaymentStatus paymentStatus;

    public CreditCardResponse(CreditCardPayment creditCardPayment) {
        this.paymentStatus = creditCardPayment.getPaymentStatus();
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }
}
