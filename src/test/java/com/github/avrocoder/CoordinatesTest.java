package com.github.avrocoder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoordinatesTest {
    private Coordinates coordinates;
    @BeforeEach
    void setUp() {
        coordinates = new Coordinates(10, 20);
    }

    @Test
    void getX() {
        assertEquals(10, coordinates.getX());
    }

    @Test
    void setX() {
        coordinates.setX(54);
        assertEquals(54, coordinates.getX());
    }

    @Test
    void getY() {
        assertEquals(20, coordinates.getY());
    }

    @Test
    void setY() {
        coordinates.setY(38);
        assertEquals(38, coordinates.getY());
    }

    @Test
    void shiftHorizontal() {
        Coordinates shiftCoordinates = coordinates.shift(Orientation.HORIZONTAL, 3);
        assertEquals(13, shiftCoordinates.getX());
        assertEquals(20, shiftCoordinates.getY());
    }
    @Test
    void shiftVertical() {
        Coordinates shiftCoordinates = coordinates.shift(Orientation.VERTICAL, 3);
        assertEquals(10, shiftCoordinates.getX());
        assertEquals(23, shiftCoordinates.getY());
    }

    @Test
    void shiftX() {
        Coordinates shiftCoordinates = coordinates.shiftX(5);
        assertEquals(15, shiftCoordinates.getX());
    }

    @Test
    void shiftY() {
        Coordinates shiftCoordinates = coordinates.shiftY(7);
        assertEquals(27, shiftCoordinates.getY());
    }
}