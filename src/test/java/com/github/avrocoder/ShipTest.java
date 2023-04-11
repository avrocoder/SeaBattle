package com.github.avrocoder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ShipTest {
    private Ship shipHorizontal;
    private Ship shipVertical;
    private final ShipStatus defaultShipStatus = ShipStatus.INTACT;
    @BeforeEach
    void setUp() {
        shipHorizontal = new Ship(new Coordinates(3, 5), 3, Orientation.HORIZONTAL);
        shipVertical = new Ship(new Coordinates(8, 6), 4, Orientation.VERTICAL);
    }

    @Test
    void getSize() {
        assertEquals(3, shipHorizontal.getSize());
        assertEquals(4, shipVertical.getSize());
    }
    @Test
    void getStatus() {
        assertEquals(defaultShipStatus, shipHorizontal.getStatus());
        assertEquals(defaultShipStatus, shipVertical.getStatus());
    }

    @Test
    void checkHeadCoordinatesShip() {
        assertEquals(3, shipHorizontal.getHeadCoordinates().getX());
        assertEquals(5, shipHorizontal.getHeadCoordinates().getY());
    }

    @Test
    void checkCorrectCoordinatesDecksOnHorizontalShip() {
        assertEquals(new Coordinates(3, 5), shipHorizontal.getMapEntryDeckByNumber(0).getKey());
        assertEquals(new Coordinates(4, 5), shipHorizontal.getMapEntryDeckByNumber(1).getKey());
        assertEquals(new Coordinates(5, 5), shipHorizontal.getMapEntryDeckByNumber(2).getKey());
    }
    @Test
    void checkCorrectCoordinatesDecksOnVerticalShip() {
        assertEquals(new Coordinates(8, 6), shipVertical.getMapEntryDeckByNumber(0).getKey());
        assertEquals(new Coordinates(8, 7), shipVertical.getMapEntryDeckByNumber(1).getKey());
        assertEquals(new Coordinates(8, 8), shipVertical.getMapEntryDeckByNumber(2).getKey());
        assertEquals(new Coordinates(8, 9), shipVertical.getMapEntryDeckByNumber(3).getKey());
    }
    @Test
    void testGetDefaultStatus() {
        assertEquals(defaultShipStatus, shipHorizontal.getStatus());
        assertEquals(defaultShipStatus, shipVertical.getStatus());
    }
    @Test
    void damagedAndDestroyedHorizontalShipStatus() {
        //first deck damage
        shipHorizontal.getMapEntryDeckByNumber(0).getValue().setDamaged();
        assertEquals(ShipStatus.DAMAGED, shipHorizontal.getStatus());
        //second deck damage
        shipHorizontal.getMapEntryDeckByNumber(1).getValue().setDamaged();
        assertEquals(ShipStatus.DAMAGED, shipHorizontal.getStatus());
        //third deck damage
        shipHorizontal.getMapEntryDeckByNumber(2).getValue().setDamaged();
        //ship has destroyed
        assertEquals(ShipStatus.DESTROYED, shipHorizontal.getStatus());
    }
    @Test
    void damagedAndDestroyedVerticalShipStatus() {
        //first deck damage
        shipVertical.getMapEntryDeckByNumber(0).getValue().setDamaged();
        assertEquals(ShipStatus.DAMAGED, shipVertical.getStatus());
        //second deck damage
        shipVertical.getMapEntryDeckByNumber(1).getValue().setDamaged();
        assertEquals(ShipStatus.DAMAGED, shipVertical.getStatus());
        //third deck damage
        shipVertical.getMapEntryDeckByNumber(2).getValue().setDamaged();
        assertEquals(ShipStatus.DAMAGED, shipVertical.getStatus());
        //forth deck damage
        shipVertical.getMapEntryDeckByNumber(3).getValue().setDamaged();
        //ship has destroyed
        assertEquals(ShipStatus.DESTROYED, shipVertical.getStatus());
    }

    @Test
    void getOrientation() {
        assertEquals(Orientation.HORIZONTAL, shipHorizontal.getOrientation());
    }

    @Test
    void getDeckByWrongNumber() {
        assertThrows(IndexOutOfBoundsException.class, () -> shipHorizontal.getMapEntryDeckByNumber(5));
    }

}