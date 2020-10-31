package io.github.emanuelcerqueira.wirecardbackendchallenge.core.model;

public interface PaymentVisitor {

    Object visit(BoletoPayment boletoPayment);
    Object visit(CreditCardPayment creditCardPayment);
}
