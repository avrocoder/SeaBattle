package com.github.avrocoder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoveTest {
    private ShotsField shotsField;
    @BeforeEach
    void setUp() {
        shotsField = new ShotsField(8, 12);
    }

    @Test
    void MoveToEmptyCorrectCell() {
        Coordinates coordinates = new Coordinates(1, 1);
        Move move = new Move(coordinates, shotsField);

        boolean result = move.make();

        assertTrue(result);
    }

    @Test
    void MoveToOccupiedCell() {
        Coordinates coordinates = new Coordinates(1, 1);
        Move move = new Move(coordinates, shotsField);

        move.make();

        assertThrows(RuntimeException.class, move::make);
    }

    @Test
    void shotToOutOfBoundsFieldWidth() {
        Coordinates shotCoordinate = new Coordinates(8, 11);

        assertThrows(RuntimeException.class, () -> new Move(shotCoordinate, shotsField).make());
    }
    @Test
    void shotToOutOfBoundsFieldHeight() {
        Coordinates shotCoordinate = new Coordinates(7, 12);

        assertThrows(RuntimeException.class, () -> new Move(shotCoordinate, shotsField).make());
    }

}