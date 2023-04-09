package com.github.avrocoder;

import java.util.LinkedHashMap;
import java.util.Map;

public class Ship {
    private final Coordinates headCoordinates;
    private final int size;
    private final Orientation orientation;
    private ShipStatus status;
    private final Map<Coordinates, Deck> decks = new LinkedHashMap<>();

    public Ship(Coordinates headCoordinates, int size, Orientation orientation) {
        this.headCoordinates = headCoordinates;
        this.size = size;
        this.orientation = orientation;
        this.status = ShipStatus.INTACT;
        decksInit();
    }

    private void decksInit() {
        for (int i = 0; i < size; i++) {
            Coordinates deckCoordinate = headCoordinates.shift(this.orientation, i);
            decks.put(deckCoordinate, new Deck(deckCoordinate, this));
        }
    }

    public Coordinates getHeadCoordinates() {
        return headCoordinates;
    }

    public int getSize() {
        return size;
    }

    public ShipStatus getStatus() {
        if (status == ShipStatus.DESTROYED) return status;
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

    public void setStatus(ShipStatus status) {
        if (status == ShipStatus.DESTROYED) {
            for (Deck deck: this.getDecks().values()) {
                deck.setDamaged();
            }
        }
        this.status = status;
    }
}
