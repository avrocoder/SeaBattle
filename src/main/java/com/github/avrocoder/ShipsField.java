package com.github.avrocoder;

public class ShipsField extends Field<Deck>{

    public ShipsField(int width, int height) {
        super(width, height);
    }

    public void placeShip(Ship ship) {
        //todo check possibility ship place through validator
        ship.getDecks().forEach(this::place);
    }
}
