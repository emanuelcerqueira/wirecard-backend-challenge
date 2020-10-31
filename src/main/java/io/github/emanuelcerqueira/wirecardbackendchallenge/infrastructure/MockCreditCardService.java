package io.github.emanuelcerqueira.wirecardbackendchallenge.infrastructure;

import io.github.emanuelcerqueira.wirecardbackendchallenge.core.model.CreditCardPayment;
import io.github.emanuelcerqueira.wirecardbackendchallenge.core.services.CreditCardService;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class MockCreditCardService implements CreditCardService {

    @Override
    public void processPayment(CreditCardPayment creditCardPayment) {
        Random random = new Random();

        if (random.nextBoolean()) {
            creditCardPayment.setPaymentStatusToAccepted();
        }
        else {
            creditCardPayment.setPaymentStatusToRejected();
        }

    }

}
