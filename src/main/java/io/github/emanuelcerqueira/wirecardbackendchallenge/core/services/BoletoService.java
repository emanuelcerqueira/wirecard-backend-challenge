package io.github.emanuelcerqueira.wirecardbackendchallenge.core.services;

import io.github.emanuelcerqueira.wirecardbackendchallenge.core.model.BoletoPayment;

public interface BoletoService {
    void processPayment(BoletoPayment boletoPayment);
}
