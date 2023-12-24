package com.food.ordering.system.domain.events;

public final class EmptyEvent implements DomainEvents<Void> {
    public static EmptyEvent INSTANCE = new EmptyEvent();

    private EmptyEvent() {
    }

    @Override
    public void fire() {

    }
}