package com.github.avrocoder;

public class Player {
    private String name;
    private ShipsField shipsField;
    private ShotsField shotsField;

    public Player(String name, ShipsField shipsField, ShotsField shotsField) {
        this.name = name;
        this.shipsField = shipsField;
        this.shotsField = shotsField;
    }

    public String getName() {
        return name;
    }

    public ShipsField getShipsField() {
        return shipsField;
    }

    public ShotsField getShotsField() {
        return shotsField;
    }
}
