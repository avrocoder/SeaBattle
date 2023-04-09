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
        expectedDecks.put(new Coordinates(3, 5), new Deck(new Coordinates(3, 5),shipHorizontal));
        expectedDecks.put(new Coordinates(4, 5), new Deck(new Coordinates(4, 5), shipHorizontal));
        expectedDecks.put(new Coordinates(5, 5), new Deck(new Coordinates(5, 5), shipHorizontal));
        assertEquals(factDecks,expectedDecks);

        factDecks = shipVertical.getDecks();
        expectedDecks = new HashMap<>();
        expectedDecks.put(new Coordinates(8, 6), new Deck(new Coordinates(8, 6),shipVertical));
        expectedDecks.put(new Coordinates(8, 7), new Deck(new Coordinates(8, 7),shipVertical));
        expectedDecks.put(new Coordinates(8, 8), new Deck(new Coordinates(8, 8),shipVertical));
        expectedDecks.put(new Coordinates(8, 9), new Deck(new Coordinates(8, 9),shipVertical));
        assertEquals(factDecks,expectedDecks);
    }
    @Test
    void testGetDefaultStatus() {
        assertEquals(defaultShipStatus, shipHorizontal.getStatus());
        assertEquals(defaultShipStatus, shipVertical.getStatus());
    }
    @Test
    void testGetDamagedAndDestroyedHorizontalShipStatus() {
        //first deck damage
        shipHorizontal.getDecks().get(shipHorizontal.getHeadCoordinates()).setDamaged();
        assertEquals(ShipStatus.DAMAGED, shipHorizontal.getStatus());

        //second deck damage
        shipHorizontal.getDecks().get(shipHorizontal.getHeadCoordinates().shiftX(1)).setDamaged();
        assertEquals(ShipStatus.DAMAGED, shipHorizontal.getStatus());

        //third deck damage
        shipHorizontal.getDecks().get(shipHorizontal.getHeadCoordinates().shiftX(2)).setDamaged();
        //ship has destroyed
        assertEquals(ShipStatus.DESTROYED, shipHorizontal.getStatus());
    }
    @Test
    void testGetDamagedAndDestroyedVerticalShipStatus() {
        //first deck damage
        shipVertical.getDecks().get(shipVertical.getHeadCoordinates()).setDamaged();
        assertEquals(ShipStatus.DAMAGED, shipVertical.getStatus());

        //second deck damage
        shipVertical.getDecks().get(shipVertical.getHeadCoordinates().shiftY(1)).setDamaged();
        assertEquals(ShipStatus.DAMAGED, shipVertical.getStatus());

        //third deck damage
        shipVertical.getDecks().get(shipVertical.getHeadCoordinates().shiftY(2)).setDamaged();
        assertEquals(ShipStatus.DAMAGED, shipVertical.getStatus());

        //fourth deck damage
        shipVertical.getDecks().get(shipVertical.getHeadCoordinates().shiftY(3)).setDamaged();
        assertEquals(ShipStatus.DESTROYED, shipVertical.getStatus());

    }

    @Test
    void getOrientation() {
        assertEquals(Orientation.HORIZONTAL, shipHorizontal.getOrientation());
    }



}