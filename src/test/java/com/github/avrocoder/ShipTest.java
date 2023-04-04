package com.github.avrocoder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShipTest {
    private Ship ship;
    private Coordinates coordinates;
    private int size;
    private final ShipStatus defaultShipStatus = ShipStatus.INTACT;
    @BeforeEach
    void setUp() {
        coordinates = new Coordinates(10, 20);
        size = 3;
        this.ship = new Ship(coordinates, size);
    }
    @Test
    void getCoordinates() {
        assertEquals(coordinates, ship.getCoordinates());
    }
    @Test
    void getSize() {
        assertEquals(size, ship.getSize());
    }
    @Test
    void getStatus() {
        assertEquals(defaultShipStatus, ship.getStatus());
    }
    @Test
    void setStatus() {
        ship.setStatus(ShipStatus.DAMAGED);
        assertEquals(ShipStatus.DAMAGED, ship.getStatus());
    }
}