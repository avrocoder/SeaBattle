package com.github.avrocoder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoveTest {
    private ShotsField shotsField;
    private ShipsField shipsField;
    @BeforeEach
    void setUp() {
        shotsField = new ShotsField(10, 10);
        shipsField = new ShipsField(10, 10);
    }

    @Test
    void checkExistenceShotOnField() {
        Move move = new Move(shotsField, shipsField);
        Coordinates coordinates = new Coordinates(0, 0);
        move.make(coordinates);

        Shot shot = shotsField.getField().get(coordinates);

        assertEquals(coordinates, shot.getCoordinates());
    }


}