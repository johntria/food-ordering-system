package com.food.ordering.system.saga;

import com.food.ordering.system.domain.events.DomainEvents;

public interface SagaStep<T, S extends DomainEvents, U extends DomainEvents> {
    S process(T data);

    U rollback(T data);
}