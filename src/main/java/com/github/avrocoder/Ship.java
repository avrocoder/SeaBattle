package com.github.avrocoder;
public class Ship {
    private final Coordinates coordinates;
    private final int size;
    private ShipStatus status;
    public Ship(Coordinates coordinates, int size) {
        this.coordinates = coordinates;
        this.size = size;
        this.status = ShipStatus.INTACT;
    }
    public Coordinates getCoordinates() {
        return coordinates;
    }
    public int getSize() {
        return size;
    }
    public ShipStatus getStatus() {
        return status;
    }
    public void setStatus(ShipStatus status) {
        this.status = status;
    }
}
