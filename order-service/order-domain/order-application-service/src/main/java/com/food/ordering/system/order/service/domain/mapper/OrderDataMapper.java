package com.food.ordering.system.order.service.domain.mapper;

import java.util.List;
import java.util.UUID;

import com.food.ordering.system.order.service.domain.dto.create.OrderItem;
import org.springframework.stereotype.Component;

import com.food.ordering.system.domain.valueobject.CustomerId;
import com.food.ordering.system.domain.valueobject.Money;
import com.food.ordering.system.domain.valueobject.ProductId;
import com.food.ordering.system.domain.valueobject.RestaurantId;
import com.food.ordering.system.domain.valueobject.StreetAddress;
import com.food.ordering.system.order.service.domain.dto.create.CreateOrderCommand;
import com.food.ordering.system.order.service.domain.dto.create.CreateOrderResponse;
import com.food.ordering.system.order.service.domain.dto.create.OrderAddress;
import com.food.ordering.system.order.service.domain.dto.track.TrackOrderResponse;
import com.food.ordering.system.order.service.domain.entity.Order;
import com.food.ordering.system.order.service.domain.entity.Product;
import com.food.ordering.system.order.service.domain.entity.Restaurant;

@Component
public class OrderDataMapper {
	public Restaurant createOrderCommandToRestaurant(CreateOrderCommand createOrderCommand) {
		return Restaurant.builder()
				.restaurantId(new RestaurantId(createOrderCommand.getRestaurantId()))
				.products(
						createOrderCommand.getItems().stream().map(
								orderItem -> new Product(new ProductId(orderItem.getProductId()))
						).toList()
				)
				.build();
	}

	public Order createOrderCommandToOrder(CreateOrderCommand createOrderCommand) {
		return Order.newBuilder()
				.customerId(new CustomerId(createOrderCommand.getCustomerId()))
				.restaurantId(new RestaurantId(createOrderCommand.getRestaurantId()))
				.deliveryAddress(orderAddressToStreetAddress(createOrderCommand.getAddress()))
				.price(new Money(createOrderCommand.getPrice()))
				.items(orderItemsToOrderItemsEntity(createOrderCommand.getItems()))
				.build();

	}

	private List<com.food.ordering.system.order.service.domain.entity.OrderItem> orderItemsToOrderItemsEntity(List<OrderItem> orderItems) {
		return orderItems.stream().map(
				orderItem -> com.food.ordering.system.order.service.domain.entity.OrderItem.builder()
						.product(new Product(new ProductId(orderItem.getProductId())))
						.price(new Money(orderItem.getPrice()))
						.quantity(orderItem.getQuantity())
						.subTotal(new Money(orderItem.getSubTotal()))
						.build()
		).toList();
	}

	private StreetAddress orderAddressToStreetAddress(OrderAddress address) {
		return new StreetAddress(UUID.randomUUID(), address.getStreet(), address.getPostalCode(), address.getCity());
	}

	public CreateOrderResponse orderToCreateOrderResponse(Order order,String message) {
		return CreateOrderResponse.builder()
				.orderTackingId(order.getTrackingId().getValue())
				.orderStatus(order.getOrderStatus())
				.message(message)
				.build();
	}

	public TrackOrderResponse orderToTrackOrderResponse(Order order) {
		return TrackOrderResponse.builder()
				.orderTrackingId(order.getTrackingId().getValue())
				.orderStatus(order.getOrderStatus())
				.failureMessages(order.getFailureMessages())
				.build();
	}
}