package io.github.emanuelcerqueira.wirecardbackendchallenge.core.model;

import io.github.emanuelcerqueira.wirecardbackendchallenge.shared.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class Client extends BaseEntity {
    private String name;

    public String getName() {
        return name;
    }

    public Client() {
    }

    public Client(String name) {
        this.name = name;
    }
}
