package com.github.avrocoder.validations;

import com.github.avrocoder.Coordinates;
import com.github.avrocoder.Orientation;
import com.github.avrocoder.Ship;
import com.github.avrocoder.ShipsField;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShipValidationTest {
    private ShipsField shipsField;

    @BeforeEach
    void setUp() {
        shipsField = new ShipsField(10, 10);
    }

    @Test
    void occupiedCell() {
        Ship ship1 = new Ship(new Coordinates(5, 5),4, Orientation.HORIZONTAL);
        Ship ship2 = new Ship(new Coordinates(5, 2),4, Orientation.VERTICAL);
        shipsField.placeShip(ship1);
        Validation validation = new ShipValidation(ship2, shipsField);
        assertFalse(validation.validate());
    }

    @Test
    void shipIsOutOfBounds() {
        Ship ship1 = new Ship(new Coordinates(-1, 5),4, Orientation.HORIZONTAL);
        ShipValidation shipValidation1 = new ShipValidation(ship1, shipsField);
        Ship ship2 = new Ship(new Coordinates(5, -1),4, Orientation.VERTICAL);
        ShipValidation shipValidation2 = new ShipValidation(ship2, shipsField);
        Ship ship3 = new Ship(new Coordinates(7, 5),4, Orientation.HORIZONTAL);
        ShipValidation shipValidation3 = new ShipValidation(ship3, shipsField);
        Ship ship4 = new Ship(new Coordinates(5, 7),4, Orientation.VERTICAL);
        ShipValidation shipValidation4 = new ShipValidation(ship4, shipsField);

        assertFalse(shipValidation1.validate());
        assertFalse(shipValidation2.validate());
        assertFalse(shipValidation3.validate());
        assertFalse(shipValidation4.validate());
    }

    @Test
    void missingShipsNearby() {
        Ship shipExist1 = new Ship(new Coordinates(5, 3),1, Orientation.HORIZONTAL);
        shipsField.placeShip(shipExist1);
        Ship shipExist2 = new Ship(new Coordinates(8, 7),1, Orientation.HORIZONTAL);
        shipsField.placeShip(shipExist2);
        Ship shipExist3 = new Ship(new Coordinates(3, 5),1, Orientation.HORIZONTAL);
        shipsField.placeShip(shipExist3);

        Ship ship = new Ship(new Coordinates(5, 5),4, Orientation.HORIZONTAL);
        ShipValidation shipValidation = new ShipValidation(ship, shipsField);

        shipValidation.validate();
        System.out.println(shipValidation.getMessages());
        assertTrue(shipValidation.validate());
    }

    @Test
    void existShipsNearby() {
        Coordinates[] coordinates= {
                new Coordinates(4, 4),
                new Coordinates(6, 4),
                new Coordinates(9, 4),
                new Coordinates(9, 5),
                new Coordinates(9, 6),
                new Coordinates(7, 6),
                new Coordinates(4, 6),
                new Coordinates(4, 5),
        };

        for (Coordinates coordinate: coordinates) {
            Ship shipExist = new Ship(coordinate,1, Orientation.HORIZONTAL);
            shipsField.placeShip(shipExist);

            Ship ship = new Ship(new Coordinates(5, 5),4, Orientation.HORIZONTAL);
            ShipValidation shipValidation = new ShipValidation(ship, shipsField);
            assertFalse(shipValidation.validate());

            setUp();
        }
    }

}