package io.github.emanuelcerqueira.wirecardbackendchallenge.core.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "credit_card_payment")
public class CreditCardPayment extends Payment {

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "credit_card_id")
    private CreditCard creditCard;

    public CreditCardPayment() {
    }

    @Override
    public Object accept(PaymentVisitor paymentProcessorVisitor) {
        return paymentProcessorVisitor.visit(this);
    }

    public CreditCardPayment(Client client, Buyer buyer, BigDecimal amount, CreditCard creditCard) {
        super(client, buyer, amount);
        this.creditCard = creditCard;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }
}
