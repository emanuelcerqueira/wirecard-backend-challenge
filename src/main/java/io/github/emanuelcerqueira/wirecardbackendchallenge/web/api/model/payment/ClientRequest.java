package io.github.emanuelcerqueira.wirecardbackendchallenge.web.api.model.payment;

import com.fasterxml.jackson.annotation.JsonRootName;
import io.github.emanuelcerqueira.wirecardbackendchallenge.core.model.Client;
import io.github.emanuelcerqueira.wirecardbackendchallenge.core.repository.ClientRepository;
import io.github.emanuelcerqueira.wirecardbackendchallenge.core.services.exception.ObjectNotFoundException;

import javax.validation.constraints.NotEmpty;
import java.util.UUID;

@JsonRootName("client")
public class ClientRequest {

    @NotEmpty(message = "Must not be empty.")
    private String id;

    public String getId() {
        return id;
    }

    public Client toEntity(ClientRepository clientRepository) {
        return clientRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new ObjectNotFoundException("Client doesn't exist."));
    }
}
