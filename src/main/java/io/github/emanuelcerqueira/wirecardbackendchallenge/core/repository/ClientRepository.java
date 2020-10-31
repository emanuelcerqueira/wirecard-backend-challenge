package io.github.emanuelcerqueira.wirecardbackendchallenge.core.repository;

import io.github.emanuelcerqueira.wirecardbackendchallenge.core.model.Client;
import io.github.emanuelcerqueira.wirecardbackendchallenge.core.model.Payment;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ClientRepository extends CrudRepository<Client, UUID> {
}
