package com.food.ordering.system.payment.service.domain.ports.output.message.publisher;

import com.food.ordering.system.domain.events.publishier.DomainEventPublisher;
import com.food.ordering.system.payment.service.domain.event.PaymentCompletedEvent;

public interface PaymentCompletedMessagePublisher extends DomainEventPublisher<PaymentCompletedEvent> {
}