package com.food.ordering.system.order.service.domain;

import com.food.ordering.system.order.service.domain.ports.input.service.OrderApplicationService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.food.ordering.system.order.service.domain.dto.create.CreateOrderCommand;
import com.food.ordering.system.order.service.domain.dto.create.CreateOrderResponse;
import com.food.ordering.system.order.service.domain.dto.track.TrackOrderQuery;
import com.food.ordering.system.order.service.domain.dto.track.TrackOrderResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Validated //We have to use validated annotation in order to validate the input parameter
class OrderApplicationServiceImpl implements OrderApplicationService {
	private final OrderCreateCommandHandler orderCreateCommandHandler;
	private final OrderTrackCommandHandler orderTrackCommandHandler;

	public OrderApplicationServiceImpl(OrderCreateCommandHandler orderCreateCommandHandler,
									   OrderTrackCommandHandler orderTrackCommandHandler) {
		this.orderCreateCommandHandler = orderCreateCommandHandler;
		this.orderTrackCommandHandler = orderTrackCommandHandler;
	}

	@Override
	public CreateOrderResponse createOrder(CreateOrderCommand createOrderCommand) {
		return orderCreateCommandHandler.createOrder(createOrderCommand);
	}

	@Override
	public TrackOrderResponse trackOrder(TrackOrderQuery trackOrderQuery) {
		return orderTrackCommandHandler.trackOrderResponse(trackOrderQuery);
	}
}