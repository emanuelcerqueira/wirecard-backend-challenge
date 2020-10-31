package io.github.emanuelcerqueira.wirecardbackendchallenge.web.api.model.payment;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.emanuelcerqueira.wirecardbackendchallenge.core.model.CreditCard;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.Set;

public class CardRequest {

    @NotNull(message = "Must not be empty.")
    @JsonProperty("holder_name")
    private String holderName;

    @NotNull(message = "Must not be empty.")
    @CreditCardNumber(message = "Invalid credit card number.")
    private String number;

    @Future(message = "Credit card is expired.")
    @JsonProperty("expiration_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM")
    private Date expirationDate;

    @NotNull(message = "Must not be empty.")
    @Pattern(regexp = "[0-9]{3,4}", message = "Invalid CVV.")
    private String cvv;

    public CardRequest() {
    }

    public String getHolderName() {
        return holderName;
    }

    public String getNumber() {
        return number;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public String getCvv() {
        return cvv;
    }

    public CreditCard toEntity(Validator validator) {
        Set<ConstraintViolation<CardRequest>> violations = validator.validate(this);

        if (!violations.isEmpty())
            throw new ConstraintViolationException(violations);

        return new CreditCard(
                holderName,
                number,
                getExpirationLocalDate(),
                cvv
        );
    }

    private LocalDate getExpirationLocalDate() {
        LocalDate expirationLocalDate = expirationDate
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate()
                // A credit card expires on the last day of the month
                .with(TemporalAdjusters.lastDayOfMonth());

        return expirationLocalDate;
    }
}
