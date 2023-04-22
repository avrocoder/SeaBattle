package com.github.avrocoder;

    public class Move {
    private final ShotsField shotsField;
    private final ShipsField shipsField;
    private boolean hit = false;
    public Move(ShotsField shotsField, ShipsField shipsField) {
        this.shotsField = shotsField;
        this.shipsField = shipsField;
    }

        public boolean isHit() {
            return hit;
        }

        public void make(Coordinates coordinates) {
        shotsField.place(coordinates, new Shot(coordinates));
        Deck deck = shipsField.getField().get(coordinates);
        if(shipsField.getField().containsKey(coordinates)) {
            deck.setDamaged();
            hit = true;
        }
    }


}
