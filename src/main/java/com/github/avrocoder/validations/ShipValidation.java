package com.github.avrocoder.validations;
import com.github.avrocoder.*;


import java.util.Iterator;
import java.util.Map;

public class ShipValidation extends Validation{
    private Ship ship;

    public ShipValidation (Ship ship, ShipsField field) {
        super(field);
        this.ship = ship;
    }

    public boolean validate() {
        Map decks = ship.getDecks();
        Iterator<Coordinates> iterator = decks.keySet().iterator();
        while(iterator.hasNext()) {
            setCoordinates(iterator.next());
            if (!isValidEmptyCell() || !isValidOutOfBounds() || !isMissingShipsNearby()) {
                return false;
            }
        }
        return true;
    }

    private boolean isMissingShipsNearby() {
        for (int i = 0; i < ship.getSize() + 2; i++) {
            for (int j = 0; j < 3; j++) {
                Coordinates headCoordinates = ship.getHeadCoordinates();
                Coordinates checkCoordinates;
                if (ship.getOrientation() == Orientation.HORIZONTAL) {
                    checkCoordinates = headCoordinates.shift(i-1, j-1);
                } else {
                    checkCoordinates = headCoordinates.shift(j-1, i-1);
                }
                if (!field.isEmptyCell(checkCoordinates)) {
                    addMessage("Exists ship near these coordinates");
                    return false;
                }
            }
        }
        return true;
    }

}
