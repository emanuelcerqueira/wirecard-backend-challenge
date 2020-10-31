package io.github.emanuelcerqueira.wirecardbackendchallenge.infrastructure;

import io.github.emanuelcerqueira.wirecardbackendchallenge.core.model.BoletoPayment;
import io.github.emanuelcerqueira.wirecardbackendchallenge.core.services.BoletoService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

@Service
public class MockBoletoService implements BoletoService {

    @Override
    public void processPayment(BoletoPayment boletoPayment) {
        String boletoNumber = RandomStringUtils.randomNumeric(48);
        boletoPayment.setNumber(boletoNumber);
    }
}
