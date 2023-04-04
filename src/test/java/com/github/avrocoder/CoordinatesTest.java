package com.github.avrocoder;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoordinatesTest {
    private static Coordinates coordinates;
    @BeforeAll
    static void beforeAll() {
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

}