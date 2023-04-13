package com.github.avrocoder.validations;

import com.github.avrocoder.Coordinates;
import com.github.avrocoder.Field;

import java.util.ArrayList;

public class Validation {
    private final Coordinates coordinates;
    private final Field field;
    private final ArrayList<String> message = new ArrayList<>();

    public Validation(Coordinates coordinates, Field field) {
        this.coordinates = coordinates;
        this.field = field;
    }

    public ArrayList<String> getMessage() {
        return message;
    }

    public boolean validate() {
        return isValidEmptyCell() && isValidOutOfBoundsShot();
    }

    private boolean isValidEmptyCell() {
        if (field.isEmptyCell(coordinates)) {
            return true;
        } else {
            message.add("Cell is occupied");
            return false;
        }
    }

    private boolean isValidOutOfBoundsShot() {
        if (coordinates.getX() < field.getWidth() && coordinates.getY() < field.getHeight()) {
            return true;
        } else {
            message.add("Coordinates are out of bounds");
            return false;
        }
    }
}
