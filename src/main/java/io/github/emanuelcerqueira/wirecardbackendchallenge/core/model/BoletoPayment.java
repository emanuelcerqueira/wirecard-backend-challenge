package io.github.emanuelcerqueira.wirecardbackendchallenge.core.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "boleto_payment")
public class BoletoPayment extends Payment {

    private String number;

    public BoletoPayment() {
    }

    public BoletoPayment(Client client, Buyer buyer, BigDecimal amount) {
        super(client, buyer, amount);
    }

    @Override
    public Object accept(PaymentVisitor paymentProcessorVisitor) {
        return paymentProcessorVisitor.visit(this);
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
