package com.food.ordering.system.order.service.dataaccess.restaurant.exception;

public class RestaurantDataAccessException extends RuntimeException{
    public RestaurantDataAccessException(String message) {
        super(message);
    }

    public RestaurantDataAccessException(String message, Throwable cause) {
        super(message, cause);
    }

    public RestaurantDataAccessException(Throwable cause) {
        super(cause);
    }

    public RestaurantDataAccessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}