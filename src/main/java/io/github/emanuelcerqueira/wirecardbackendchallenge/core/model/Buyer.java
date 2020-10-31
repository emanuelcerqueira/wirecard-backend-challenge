package io.github.emanuelcerqueira.wirecardbackendchallenge.core.model;

import io.github.emanuelcerqueira.wirecardbackendchallenge.shared.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "buyer")
public class Buyer extends BaseEntity {

    private String name;
    private String email;
    private String cpf;

    public Buyer(String name, String email, String cpf) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
    }

    public Buyer() {
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }
}
