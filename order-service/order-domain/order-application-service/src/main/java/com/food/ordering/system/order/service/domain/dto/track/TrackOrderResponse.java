package com.food.ordering.system.order.service.domain.dto.track;

import java.util.List;
import java.util.UUID;

import com.food.ordering.system.domain.valueobject.OrderStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Getter
@AllArgsConstructor
@Builder
public class TrackOrderResponse {
	@NonNull
	private final UUID orderTrackingId;
	@NonNull
	private final OrderStatus orderStatus;
	private final List<String> failureMessages;
}