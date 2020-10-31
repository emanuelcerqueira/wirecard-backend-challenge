package io.github.emanuelcerqueira.wirecardbackendchallenge.web.api.model.payment;

import io.github.emanuelcerqueira.wirecardbackendchallenge.core.model.BoletoPayment;
import io.github.emanuelcerqueira.wirecardbackendchallenge.core.model.CreditCardPayment;
import io.github.emanuelcerqueira.wirecardbackendchallenge.core.model.Payment;
import io.github.emanuelcerqueira.wirecardbackendchallenge.core.repository.ClientRepository;

import javax.validation.Valid;
import javax.validation.Validator;

public class PaymentRequestBody {

    @Valid
    private ClientRequest client;
    @Valid
    private BuyerRequest buyer;
    @Valid
    private PaymentRequest payment;

    public ClientRequest getClient() {
        return client;
    }

    public BuyerRequest getBuyer() {
        return buyer;
    }

    public PaymentRequest getPayment() {
        return payment;
    }

    public Payment toEntity(Validator validator, ClientRepository clientRepository) {
        switch (payment.getPaymentType()) {

            case BOLETO:
                return new BoletoPayment(client.toEntity(clientRepository), buyer.toEntity(), payment.getAmount());

            case CREDIT_CARD:
                return new CreditCardPayment(client.toEntity(clientRepository), buyer.toEntity(), payment.getAmount(), payment.getCardRequest().toEntity(validator));

        }

        return null;
    }

}
