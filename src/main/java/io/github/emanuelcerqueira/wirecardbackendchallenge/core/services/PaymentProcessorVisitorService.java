package io.github.emanuelcerqueira.wirecardbackendchallenge.core.services;

import io.github.emanuelcerqueira.wirecardbackendchallenge.core.model.BoletoPayment;
import io.github.emanuelcerqueira.wirecardbackendchallenge.core.model.CreditCardPayment;
import io.github.emanuelcerqueira.wirecardbackendchallenge.core.model.PaymentVisitor;
import org.springframework.stereotype.Service;

@Service
public class PaymentProcessorVisitorService implements PaymentVisitor {

    private final BoletoService boletoService;
    private final CreditCardService creditCardService;

    public PaymentProcessorVisitorService(BoletoService boletoService, CreditCardService creditCardService) {
        this.boletoService = boletoService;
        this.creditCardService = creditCardService;
    }

    @Override
    public Object visit(BoletoPayment boletoPayment) {
        boletoService.processPayment(boletoPayment);
        return boletoPayment;
    }

    @Override
    public Object visit(CreditCardPayment creditCardPayment) {
        creditCardService.processPayment(creditCardPayment);
        return creditCardPayment;
    }
}
