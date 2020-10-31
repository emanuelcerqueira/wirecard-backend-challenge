package io.github.emanuelcerqueira.wirecardbackendchallenge.web.api.model.payment;

import com.fasterxml.jackson.annotation.JsonRootName;
import io.github.emanuelcerqueira.wirecardbackendchallenge.core.model.Buyer;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@JsonRootName("buyer")
public class BuyerRequest {

    @NotEmpty(message = "Must not be empty.")
    private String name;
    @NotEmpty(message = "Must not be empty.")
    @Email(message = "Invalid e-mail.")
    private String email;
    @NotEmpty(message = "Must not be empty.")
    @CPF(message = "Invalid CPF.")
    private String cpf;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public Buyer toEntity() {
        return new Buyer(name, email, cpf);
    }

}
