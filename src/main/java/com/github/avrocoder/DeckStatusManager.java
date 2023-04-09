package com.github.avrocoder;

public class DeckStatusManager {
    public static DeckStatus getCalculateStatus(Deck deck) {
        if(!deck.isDamaged()) {
            return DeckStatus.INTACT;
        } else if(deck.getShipOwner().getStatus() == ShipStatus.DESTROYED) {
            return DeckStatus.DESTROYED;
        } else {
            return DeckStatus.DAMAGED;
        }
    }
}
