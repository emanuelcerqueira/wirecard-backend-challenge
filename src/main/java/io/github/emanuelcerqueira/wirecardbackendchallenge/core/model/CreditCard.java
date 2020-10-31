package io.github.emanuelcerqueira.wirecardbackendchallenge.core.model;

import io.github.emanuelcerqueira.wirecardbackendchallenge.shared.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class CreditCard extends BaseEntity {

    @Column(name = "holder_name")
    private String holderName;
    private String number;
    @Column(name = "expiration_date")
    private LocalDate expirationDate;
    private String cvv;

    public CreditCard(String holderName, String number, LocalDate expirationDate, String cvv) {
        this.holderName = holderName;
        this.number = number;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
    }

    public CreditCard() {
    }

    public String getHolderName() {
        return holderName;
    }

    public String getNumber() {
        return number;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public String getCvv() {
        return cvv;
    }
}
