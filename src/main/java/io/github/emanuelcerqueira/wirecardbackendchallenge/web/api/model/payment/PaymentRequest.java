package io.github.emanuelcerqueira.wirecardbackendchallenge.web.api.model.payment;

import com.fasterxml.jackson.annotation.JsonRootName;
import io.github.emanuelcerqueira.wirecardbackendchallenge.core.model.Payment;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@JsonRootName("payment")
public class PaymentRequest {

    @NotNull(message = "Must not be empty.")
    @Positive(message = "Amount must be positive.")
    private BigDecimal amount;
    @NotNull(message = "Must not be empty.")
    private PaymentTypeRequest paymentType;

    private CardRequest cardRequest;

    public BigDecimal getAmount() {
        return amount;
    }

    public PaymentTypeRequest getPaymentType() {
        return paymentType;
    }

    public CardRequest getCardRequest() {
        return cardRequest;
    }
}
