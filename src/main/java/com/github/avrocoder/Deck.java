package com.github.avrocoder;

import java.util.Objects;

public class Deck {
    private final Coordinates coordinates;
    private final Ship shipOwner;
    private boolean isDamaged = false;
    public boolean isDamaged() {
        return isDamaged;
    }

    public Deck(Coordinates coordinates, Ship shipOwner) {
        this.coordinates = coordinates;
        this.shipOwner = shipOwner;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setDamaged() {
        isDamaged = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Deck deck = (Deck) o;
        return Objects.equals(coordinates, deck.coordinates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinates);
    }

    public Ship getShipOwner() {
        return shipOwner;
    }

    public DeckStatus getStatus() {
        return DeckStatusManager.getCalculateStatus(this);
    }

}
