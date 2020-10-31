package io.github.emanuelcerqueira.wirecardbackendchallenge.core.services;

import io.github.emanuelcerqueira.wirecardbackendchallenge.core.model.Payment;
import io.github.emanuelcerqueira.wirecardbackendchallenge.core.repository.PaymentRepository;
import io.github.emanuelcerqueira.wirecardbackendchallenge.core.services.exception.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final PaymentProcessorVisitorService paymentProcessor;

    public PaymentService(PaymentRepository paymentRepository, PaymentProcessorVisitorService paymentProcessor) {
        this.paymentRepository = paymentRepository;
        this.paymentProcessor = paymentProcessor;
    }

    @Transactional
    public Payment createPayment(Payment payment) {
        payment.accept(paymentProcessor);
        return paymentRepository.save(payment);
    }

    public Payment findPaymentById(UUID id) {
        return paymentRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Payment not found."));
    }
}
