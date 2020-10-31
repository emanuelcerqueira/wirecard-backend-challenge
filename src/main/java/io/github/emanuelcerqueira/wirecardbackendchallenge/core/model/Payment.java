package io.github.emanuelcerqueira.wirecardbackendchallenge.core.model;

import io.github.emanuelcerqueira.wirecardbackendchallenge.shared.BaseEntity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "payment")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Payment extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "client_id")
    protected Client client;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "buyer_id")
    protected Buyer buyer;
    protected BigDecimal amount;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    protected PaymentStatus paymentStatus;

    public Payment() {
    }

    public Payment(Client client, Buyer buyer, BigDecimal amount) {
        this.client = client;
        this.buyer = buyer;
        this.amount = amount;
        this.paymentStatus = PaymentStatus.PENDING;
    }

    public Client getClient() {
        return client;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatusToAccepted() {
        this.paymentStatus = PaymentStatus.ACCEPTED;
    }

    public void setPaymentStatusToRejected() {
        this.paymentStatus = PaymentStatus.REJECTED;
    }

    public abstract Object accept(PaymentVisitor paymentVisitor);
}
