package com.github.avrocoder;

public class ShipStatusManager {
    public static ShipStatus getCalculatedStatus(Ship ship) {
        int numDecksDestroyed = 0;
        for (Deck deck: ship.getDecks().values()) {
            if (deck.isDestroyed())
                numDecksDestroyed++;
        }
        if (numDecksDestroyed == 0) {
            return ShipStatus.INTACT;
        } else if (numDecksDestroyed != ship.getSize()) {
            return ShipStatus.DAMAGED;
        } else {
            return ShipStatus.DESTROYED;
        }
    }
}
