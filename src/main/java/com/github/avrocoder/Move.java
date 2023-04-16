package com.github.avrocoder;

import com.github.avrocoder.validations.MoveValidation;
import com.github.avrocoder.validations.Validation;

public class Move {
    private final ShotsField shotsField;
    public Move(ShotsField shotsField) {
        this.shotsField = shotsField;
    }

    public void make(Coordinates coordinates) {
        shotsField.place(coordinates, new Shot(coordinates));
    }


}
