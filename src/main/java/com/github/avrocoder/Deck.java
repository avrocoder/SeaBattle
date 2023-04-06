package com.github.avrocoder;

import java.util.Objects;

public class Deck {
    private boolean isDestroyed = false;
    public boolean isDestroyed() {
        return isDestroyed;
    }

    public void setDestroyedStatus() {
        isDestroyed = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Deck deck = (Deck) o;
        return isDestroyed == deck.isDestroyed;
    }
    @Override
    public int hashCode() {
        return Objects.hash(isDestroyed);
    }
}
