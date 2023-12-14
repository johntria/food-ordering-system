package com.food.ordering.system.order.service.domain.dto.create;

import java.util.UUID;

import com.food.ordering.system.domain.valueobject.OrderStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

import javax.validation.constraints.NotNull;

@Getter
@Builder
@AllArgsConstructor
public class CreateOrderResponse {
	@NotNull
	private final UUID orderTackingId;
	@NotNull
	private final OrderStatus orderStatus;
	@NotNull
	private final String message;
}