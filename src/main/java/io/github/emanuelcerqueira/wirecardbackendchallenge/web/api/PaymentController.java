package io.github.emanuelcerqueira.wirecardbackendchallenge.web.api;

import io.github.emanuelcerqueira.wirecardbackendchallenge.core.model.Payment;
import io.github.emanuelcerqueira.wirecardbackendchallenge.core.repository.ClientRepository;
import io.github.emanuelcerqueira.wirecardbackendchallenge.core.services.PaymentService;
import io.github.emanuelcerqueira.wirecardbackendchallenge.web.api.components.PaymentResponseVisitor;
import io.github.emanuelcerqueira.wirecardbackendchallenge.web.api.model.payment.PaymentRequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.Validator;
import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private final Validator validator;
    private final PaymentService paymentService;
    private final ClientRepository clientRepository;
    private final PaymentResponseVisitor paymentResponseVisitor;

    public PaymentController(Validator validator, PaymentService paymentService, ClientRepository clientRepository, PaymentResponseVisitor paymentResponseVisitor) {
        this.validator = validator;
        this.paymentService = paymentService;
        this.clientRepository = clientRepository;
        this.paymentResponseVisitor = paymentResponseVisitor;
    }

    @PostMapping
    public ResponseEntity<?> createPayment(@Valid @RequestBody PaymentRequestBody request) {
        Payment newPayment = request.toEntity(validator, clientRepository);
        Payment createdPayment = paymentService.createPayment(newPayment);
        Object response = createdPayment.accept(paymentResponseVisitor);

        URI resourceUri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(createdPayment.getId()).toUri();

        return ResponseEntity.created(resourceUri).body(response);
    }

    @GetMapping(value = "/{id}")
    private ResponseEntity<Payment> findPaymentById(@PathVariable String id) {
        Payment payment = paymentService.findPaymentById(UUID.fromString(id));
        return ResponseEntity.ok().body(payment);
    }

}
