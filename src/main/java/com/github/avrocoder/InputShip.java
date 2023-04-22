package com.github.avrocoder;

import com.github.avrocoder.validations.ShipValidation;

import java.util.Scanner;

public class InputShip {
    public static void input(ShipsField shipsField, int sizeShip) {
        Scanner scanner = new Scanner(System.in);
        boolean validate;
        Orientation orientation;
        do {
            System.out.println("=== Input ship (decks Number ["+ sizeShip + "]) ===");
            System.out.println("Input head coordinates X");
            int x = scanner.nextInt();
            System.out.println("Input head coordinates Y");
            int y = scanner.nextInt();
            if (sizeShip != 1) {
                System.out.println("Input orientation [0 - Horizontal, 1 - Vertical]");
                int numberOrientation = scanner.nextInt();
                orientation = (numberOrientation == 0) ? Orientation.HORIZONTAL : Orientation.VERTICAL;
            } else {
                orientation = Orientation.HORIZONTAL;
             }
            Ship ship = new Ship(new Coordinates(x, y), sizeShip, orientation);
            ShipValidation shipValidation = new ShipValidation(ship, shipsField);
            validate = shipValidation.validate();
            if(validate) {
                shipsField.placeShip(ship);
            }
            if(shipValidation.hasError()) System.out.println(shipValidation.getMessages());
        } while (!validate);

    }

}
