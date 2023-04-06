package com.github.avrocoder;

import java.util.HashMap;
import java.util.Map;

public class Ship {
    private final Coordinates headCoordinates;
    private final int size;
    private final Orientation orientation;
    private ShipStatus status;
    private final Map<Coordinates, Deck> decks = new HashMap<>();
    public Ship(Coordinates headCoordinates, int size, Orientation orientation) {
        this.headCoordinates = headCoordinates;
        this.size = size;
        this.orientation = orientation;
        this.status = ShipStatus.INTACT;
        decksInit();
    }

    private void decksInit() {
        for (int i = 0; i < size; i++) {
            decks.put(headCoordinates.shift(this.orientation, i), new Deck());
        }
    }

    public Coordinates getHeadCoordinates() {
        return headCoordinates;
    }
    public int getSize() {
        return size;
    }
    public ShipStatus getStatus() {
        status = calculateStatus();
        return status;
    }
    private ShipStatus calculateStatus() {
        return ShipStatusManager.getCalculatedStatus(this);
    }

    public Map<Coordinates, Deck> getDecks() {
        return decks;
    }

    public Orientation getOrientation() {
        return orientation;
    }
}
