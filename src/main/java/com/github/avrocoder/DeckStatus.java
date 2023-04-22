package com.github.avrocoder;

/**
 * Status deck:
 * INTACT - intact deck
 * DAMAGED - damaged deck, but its ship isn't destroyed
 * DESTROYED - damaged deck and destroyed ship
 */
public enum DeckStatus {
    INTACT,
    DAMAGED,
    DESTROYED;

    public String getImage() {
        return switch (this) {
            case INTACT -> "[ ]";
            case DAMAGED -> " X ";
            case DESTROYED -> "[X]";
        };
    }
}
