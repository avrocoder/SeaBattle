package com.github.avrocoder;

import com.github.avrocoder.validations.MoveValidation;

public class Move {
    private final Coordinates coordinates;
    private final ShotsField shotsField;
    private final MoveValidation moveValidation;
    public Move(Coordinates coordinates, ShotsField shotsField) {
        this.coordinates = coordinates;
        this.shotsField = shotsField;
        this.moveValidation = new MoveValidation(coordinates, shotsField);
    }

    public boolean make() {
        if(moveValidation.validate()) {
            shotsField.place(coordinates, new Shot(coordinates));
            return true;
        }
        throw new RuntimeException("Incorrect move");
    }

}
