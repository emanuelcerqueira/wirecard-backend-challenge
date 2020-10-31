package io.github.emanuelcerqueira.wirecardbackendchallenge.web.api;

import io.github.emanuelcerqueira.wirecardbackendchallenge.core.model.Client;
import io.github.emanuelcerqueira.wirecardbackendchallenge.core.repository.ClientRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientController {

    private final ClientRepository clientRepository;

    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @PostMapping(value = "/{name}")
    @Transactional
    public ResponseEntity<Client> newClient(@PathVariable String name) {
        return ResponseEntity.ok().body(clientRepository.save(new Client(name)));
    }
}
