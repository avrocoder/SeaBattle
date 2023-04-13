package com.github.avrocoder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShipsFieldTest {
    private final ShipsField shipsField = new ShipsField(10, 8);
    private Ship shipHorizontal;
    private Ship shipVertical;

    @BeforeEach
    void setUp() {
        shipHorizontal = new Ship(new Coordinates(7, 7), 4, Orientation.HORIZONTAL);
        shipVertical = new Ship(new Coordinates(2, 1), 3, Orientation.VERTICAL);
    }

    @Test
    void getWidth() {
        assertEquals(10, shipsField.getWidth());
    }

    @Test
    void getHeight() {
        assertEquals(8, shipsField.getHeight());
    }

    /**
     * Test for compliance of ship deck coordinates with deck coordinates on the field
     */
    @Test
    void checkComplianceCoordinatesDecksOnFieldAndDecksHorizontalShipAfterPlace() {
        shipsField.placeShip(shipHorizontal);
        Coordinates headCoordinate = shipHorizontal.getHeadCoordinates();
        Deck deckOnField1 = shipsField.getField().get(headCoordinate);
        Deck deckOnField2 = shipsField.getField().get(headCoordinate.shiftX(1));
        Deck deckOnField3 = shipsField.getField().get(headCoordinate.shiftX(2));
        Deck deckOnField4 = shipsField.getField().get(headCoordinate.shiftX(3));

        assertEquals(deckOnField1, shipHorizontal.getMapEntryDeckByNumber(0).getValue());
        assertEquals(deckOnField2, shipHorizontal.getMapEntryDeckByNumber(1).getValue());
        assertEquals(deckOnField3, shipHorizontal.getMapEntryDeckByNumber(2).getValue());
        assertEquals(deckOnField4, shipHorizontal.getMapEntryDeckByNumber(3).getValue());
    }
    @Test
    public void checkComplianceCoordinatesDecksOnFieldAndDecksVerticalShipAfterPlace() {
        shipsField.placeShip(shipVertical);
        Coordinates headCoordinate = shipVertical.getHeadCoordinates();

        Deck deckOnField1 = shipsField.getField().get(headCoordinate.shiftY(0));
        Deck deckOnField2 = shipsField.getField().get(headCoordinate.shiftY(1));
        Deck deckOnField3 = shipsField.getField().get(headCoordinate.shiftY(2));

        assertEquals(deckOnField1, shipVertical.getMapEntryDeckByNumber(0).getValue());
        assertEquals(deckOnField2, shipVertical.getMapEntryDeckByNumber(1).getValue());
        assertEquals(deckOnField3, shipVertical.getMapEntryDeckByNumber(2).getValue());

    }

    @Test
    void checkEmptyCell() {
        shipsField.placeShip(shipHorizontal);

        Coordinates coordinates1 = new Coordinates(7, 8);
        Coordinates coordinates2 = new Coordinates(8, 8);
        Coordinates coordinates3 = new Coordinates(9, 8);
        Coordinates coordinates4 = new Coordinates(10, 8);

        assertTrue(shipsField.isEmptyCell(coordinates1));
        assertTrue(shipsField.isEmptyCell(coordinates2));
        assertTrue(shipsField.isEmptyCell(coordinates3));
        assertTrue(shipsField.isEmptyCell(coordinates4));
    }

    @Test
    void checkNotEmptyCell() {
        shipsField.placeShip(shipHorizontal);

        Coordinates coordinates1 = new Coordinates(7, 7);
        Coordinates coordinates2 = new Coordinates(8, 7);
        Coordinates coordinates3 = new Coordinates(9, 7);
        Coordinates coordinates4 = new Coordinates(10, 7);

        assertFalse(shipsField.isEmptyCell(coordinates1));
        assertFalse(shipsField.isEmptyCell(coordinates2));
        assertFalse(shipsField.isEmptyCell(coordinates3));
        assertFalse(shipsField.isEmptyCell(coordinates4));
    }
}