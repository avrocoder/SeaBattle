package com.github.avrocoder;

public class Move {
    private final ShotsField shotsField;
    public Move(ShotsField shotsField) {
        this.shotsField = shotsField;
    }

    public void make(Coordinates coordinates) {
        shotsField.place(coordinates, new Shot(coordinates));
    }


}
