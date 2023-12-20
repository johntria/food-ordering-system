package com.food.ordering.system.payment.service.domain.exception;

import com.food.ordering.system.domain.exception.DomainException;

public class PaymentNotFound extends DomainException {
    public PaymentNotFound(String message) {
        super(message);
    }

    public PaymentNotFound(String message, Throwable cause) {
        super(message, cause);
    }
}