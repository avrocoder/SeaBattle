package com.github.avrocoder;

public class ShipsField extends Field<Deck>{

    public ShipsField(int width, int height) {
        super(width, height);
    }

    public ShipsField() {
        super();
    }

    public void placeShip(Ship ship) {
            ship.getDecks().forEach(this::place);
    }

    public boolean isAllShipsAreDestroyed() {
        for (Deck deck : getField().values()) {
            if(deck.getShipOwner().getStatus() != ShipStatus.DESTROYED) {
                return false;
            }
        }
        return true;
    }

}
