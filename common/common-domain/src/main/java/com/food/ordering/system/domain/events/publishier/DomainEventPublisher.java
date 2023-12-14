package com.food.ordering.system.domain.events.publishier;

import com.food.ordering.system.domain.events.DomainEvents;

public interface DomainEventPublisher <T extends DomainEvents> {
	void publish(T domainEvent);
}