package com.food.ordering.system.order.service.domain.event;

import java.time.ZonedDateTime;

import com.food.ordering.system.domain.events.DomainEvents;
import com.food.ordering.system.order.service.domain.entity.Order;

public abstract class OrderEvent implements DomainEvents<Order> {
	private final Order order;
	private final ZonedDateTime createdAt;

	public OrderEvent(Order order, ZonedDateTime createdAt) {
		this.order = order;
		this.createdAt = createdAt;
	}

	public Order getOrder() {
		return order;
	}

	public ZonedDateTime getCreatedAt() {
		return createdAt;
	}
}