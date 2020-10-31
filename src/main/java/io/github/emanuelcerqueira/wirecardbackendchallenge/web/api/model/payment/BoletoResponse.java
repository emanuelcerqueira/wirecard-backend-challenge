package io.github.emanuelcerqueira.wirecardbackendchallenge.web.api.model.payment;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.emanuelcerqueira.wirecardbackendchallenge.core.model.BoletoPayment;

public class BoletoResponse {


    @JsonProperty("boleto_number")
    private String boletoNumber;

    public BoletoResponse(BoletoPayment boletoPayment) {
        this.boletoNumber = boletoPayment.getNumber();
    }

    public String getBoletoNumber() {
        return boletoNumber;
    }
}
