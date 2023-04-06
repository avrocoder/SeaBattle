package com.github.avrocoder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ShipTest {
    private final Object[][] configShips = {
            {new Coordinates(3, 5), 3, Orientation.HORIZONTAL},
            {new Coordinates(8, 6), 4, Orientation.VERTICAL},
    };
    private Ship shipHorizontal;
    private Ship shipVertical;
    private final ShipStatus defaultShipStatus = ShipStatus.INTACT;
    @BeforeEach
    void setUp() {
        shipHorizontal = new Ship((Coordinates) configShips[0][0], (Integer) configShips[0][1], (Orientation) configShips[0][2]);
        shipVertical = new Ship((Coordinates) configShips[1][0], (Integer) configShips[1][1], (Orientation) configShips[1][2]);
    }
    @Test
    void getSize() {
        int size = (Integer) configShips[0][1];
        assertEquals(size, shipHorizontal.getSize());
        size = (Integer) configShips[1][1];
        assertEquals(size, shipVertical.getSize());
    }
    @Test
    void getStatus() {
        assertEquals(defaultShipStatus, shipHorizontal.getStatus());
        assertEquals(defaultShipStatus, shipVertical.getStatus());
    }

    @Test
    void getHeadCoordinates() {
        Coordinates coordinatesHead = (Coordinates) configShips[0][0];
        assertEquals(coordinatesHead, shipHorizontal.getHeadCoordinates());
        coordinatesHead = (Coordinates) configShips[1][0];
        assertEquals(coordinatesHead, shipVertical.getHeadCoordinates());
    }
    @Test
    void getDecks() {
        Map<Coordinates, Deck> factDecks = shipHorizontal.getDecks();
        Map<Coordinates, Deck> expectedDecks = new HashMap<>();
        expectedDecks.put(new Coordinates(3, 5), new Deck());
        expectedDecks.put(new Coordinates(4, 5), new Deck());
        expectedDecks.put(new Coordinates(5, 5), new Deck());
        assertEquals(factDecks,expectedDecks);

        factDecks = shipVertical.getDecks();
        expectedDecks = new HashMap<>();
        expectedDecks.put(new Coordinates(8, 6), new Deck());
        expectedDecks.put(new Coordinates(8, 7), new Deck());
        expectedDecks.put(new Coordinates(8, 8), new Deck());
        expectedDecks.put(new Coordinates(8, 9), new Deck());
        assertEquals(factDecks,expectedDecks);
    }
    @Test
    void testGetDefaultStatus() {
        assertEquals(defaultShipStatus, shipHorizontal.getStatus());
        assertEquals(defaultShipStatus, shipVertical.getStatus());
    }
    @Test
    void testGetDamagedAndDestroyedShipStatus() {
        //first deck damage
        shipHorizontal.getDecks().get(shipHorizontal.getHeadCoordinates()).setDestroyedStatus();
        shipVertical.getDecks().get(shipVertical.getHeadCoordinates()).setDestroyedStatus();
        assertEquals(ShipStatus.DAMAGED, shipHorizontal.getStatus());
        assertEquals(ShipStatus.DAMAGED, shipVertical.getStatus());
        //second deck damage
        shipHorizontal.getDecks().get(shipHorizontal.getHeadCoordinates().shift(
                shipHorizontal.getOrientation(),1)
        ).setDestroyedStatus();
        shipVertical.getDecks().get(shipVertical.getHeadCoordinates().shift(
                shipVertical.getOrientation(), 1)
        ).setDestroyedStatus();
        assertEquals(ShipStatus.DAMAGED, shipHorizontal.getStatus());
        assertEquals(ShipStatus.DAMAGED, shipVertical.getStatus());
        //third deck damage
        shipHorizontal.getDecks().get(shipHorizontal.getHeadCoordinates().shift(
                shipHorizontal.getOrientation(),2)
        ).setDestroyedStatus();
        shipVertical.getDecks().get(shipVertical.getHeadCoordinates().shift(
                shipVertical.getOrientation(), 2)
        ).setDestroyedStatus();
        //ShipVertical has destroyed
        assertEquals(ShipStatus.DESTROYED, shipHorizontal.getStatus());
        assertEquals(ShipStatus.DAMAGED, shipVertical.getStatus());
        //fourth deck damage
        shipVertical.getDecks().get(shipVertical.getHeadCoordinates().shift(
                shipVertical.getOrientation(), 3)
        ).setDestroyedStatus();
        assertEquals(ShipStatus.DESTROYED, shipVertical.getStatus());
    }
}