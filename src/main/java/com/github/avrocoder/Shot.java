package com.github.avrocoder;

public class Shot {
    private static int  autoincrement = 1;
    private final Coordinates coordinates;
    private final int number;

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Shot(Coordinates coordinates) {
        this.coordinates = coordinates;
        this.number = autoincrement;
        autoincrement++;
    }

    public int getNumber() {
        return number;
    }
}
