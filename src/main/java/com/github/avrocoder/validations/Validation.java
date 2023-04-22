package com.github.avrocoder.validations;

import com.github.avrocoder.Coordinates;
import com.github.avrocoder.Field;

import java.util.ArrayList;

public class Validation {
    private Coordinates coordinates;
    protected final Field field;
    private final ArrayList<String> messages = new ArrayList<>();

    public Validation(Field field) {
        this.field = field;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Validation(Coordinates coordinates, Field field) {
        this.coordinates = coordinates;
        this.field = field;
    }

    public boolean hasError() {
        return !messages.isEmpty();
    }

    public ArrayList<String> getMessages() {
        return messages;
    }

    public void addMessage(String message) {
        if(!messages.contains(message)) {
            messages.add(message);
        }
    }

    public boolean validate() {
        return isValidEmptyCell() && isValidOutOfBounds();
    }

    protected boolean isValidEmptyCell() {
        if (field.isEmptyCell(coordinates)) {
            return true;
        } else {
            addMessage("Cell is occupied");
            return false;
        }
    }

    protected boolean isValidOutOfBounds() {
        if (coordinates.getX() >= field.getWidth() || coordinates.getY() >= field.getHeight()
            || coordinates.getX() < 0 || coordinates.getY() < 0) {
            addMessage("Coordinates are out of bounds");
            return false;
        }
        return true;
    }
}
