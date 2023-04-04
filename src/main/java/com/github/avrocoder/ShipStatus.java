package com.github.avrocoder;

public enum ShipStatus {
    INTACT, DAMAGED, DESTROYED;
    public ShipStatus nextStatus() {
        if (this.ordinal() == ShipStatus.values().length - 1) {
            throw new RuntimeException("Ship status change error: Ship has already been destroyed before");
        }
        return ShipStatus.values()[this.ordinal() + 1];
    }
}
