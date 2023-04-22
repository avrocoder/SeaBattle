package com.github.avrocoder.validations;

import com.github.avrocoder.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoveValidationTest {
    private final ShotsField shotsField = new ShotsField(10, 10);
    private final ShipsField shipsField = new ShipsField(10, 10);

    @Test
    void validateCorrectMove() {
        Coordinates coordinates = new Coordinates(0, 0);
        MoveValidation moveValidation = new MoveValidation(coordinates, shotsField);

        boolean moveResult = moveValidation.validate();

        assertTrue(moveResult);
    }

    @Test
    void validateFailMoveNotEmptyCell() {
        Move move = new Move(shotsField, shipsField);
        Coordinates coordinates = new Coordinates(0, 0);
        move.make(coordinates);
        MoveValidation moveValidation = new MoveValidation(coordinates, shotsField);

        boolean moveResult = moveValidation.validate();

        assertFalse(moveResult);
    }

    @Test
    void validateFailMoveOutOfBounds() {
        Move move = new Move(shotsField, shipsField);
        Coordinates coordinates = new Coordinates(10, 10);
        move.make(coordinates);
        MoveValidation moveValidation = new MoveValidation(coordinates, shotsField);

        boolean moveResult = moveValidation.validate();

        assertFalse(moveResult);
    }
}