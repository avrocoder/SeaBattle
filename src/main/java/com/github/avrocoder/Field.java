package com.github.avrocoder;

import java.util.HashMap;
import java.util.Map;

public abstract class Field<T> {
    private final int width;
    private final int height;
    protected final Map<Coordinates, T> map = new HashMap<>();

    public Field(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Map<Coordinates, T> getField() {
        return map;
    }

    public boolean isEmptyCell(Coordinates coordinates) {
        return !map.containsKey(coordinates);
    }

     public void place(Coordinates coordinates, T object) {
        map.put(coordinates, object);
     }
}
