package io.github.emanuelcerqueira.wirecardbackendchallenge.core.services;

import io.github.emanuelcerqueira.wirecardbackendchallenge.core.model.BoletoPayment;
import io.github.emanuelcerqueira.wirecardbackendchallenge.core.model.CreditCardPayment;

public interface CreditCardService {
    void processPayment(CreditCardPayment creditCardPayment);
}
