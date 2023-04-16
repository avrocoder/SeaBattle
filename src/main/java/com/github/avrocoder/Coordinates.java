package com.github.avrocoder;

import java.util.Objects;

public class Coordinates {
    private int x, y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    public Coordinates shift(int shiftX, int shiftY) {
        return this.shiftX(shiftX).shiftY(shiftY);
    }
    public Coordinates shiftX(int shift) {
        return new Coordinates(this.getX() + shift, this.y);
    }

    public Coordinates shiftY(int shift) {
        return new Coordinates(this.x, this.getY() + shift);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
