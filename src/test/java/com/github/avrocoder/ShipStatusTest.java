package com.github.avrocoder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShipStatusTest {
    private ShipStatus shipStatus;
    private final ShipStatus defaultStatus = ShipStatus.INTACT;
    @BeforeEach
    void setUp() {
        shipStatus = defaultStatus;
    }

    @Test
    void nextStatusFromIntactToDamage() {
        ShipStatus nextStatus = shipStatus.nextStatus();
        assertEquals(nextStatus, ShipStatus.DAMAGED);
    }
    @Test
    void nextStatusFromDamagedToDestroyed() {
        shipStatus = ShipStatus.DAMAGED;
        ShipStatus nextStatus = shipStatus.nextStatus();
        assertEquals(nextStatus, ShipStatus.DESTROYED);
    }
    @Test
    void nextStatusFromDestroyedException() {
        shipStatus = ShipStatus.DESTROYED;
        assertThrows(RuntimeException.class, () -> shipStatus.nextStatus());
    }
}