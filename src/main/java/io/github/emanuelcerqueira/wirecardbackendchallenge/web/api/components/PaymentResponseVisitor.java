package io.github.emanuelcerqueira.wirecardbackendchallenge.web.api.components;

import io.github.emanuelcerqueira.wirecardbackendchallenge.core.model.BoletoPayment;
import io.github.emanuelcerqueira.wirecardbackendchallenge.core.model.CreditCardPayment;
import io.github.emanuelcerqueira.wirecardbackendchallenge.core.model.PaymentVisitor;
import io.github.emanuelcerqueira.wirecardbackendchallenge.web.api.model.payment.BoletoResponse;
import io.github.emanuelcerqueira.wirecardbackendchallenge.web.api.model.payment.CreditCardResponse;
import org.springframework.stereotype.Component;

@Component
public class PaymentResponseVisitor implements PaymentVisitor {

    @Override
    public Object visit(BoletoPayment boletoPayment) {
        return new BoletoResponse(boletoPayment);
    }

    @Override
    public Object visit(CreditCardPayment creditCardPayment) {
        return new CreditCardResponse(creditCardPayment);
    }
}
