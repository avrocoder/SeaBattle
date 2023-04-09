package com.github.avrocoder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {
    private final ArrayList<Deck> decks = new ArrayList<>();
    private Ship ship;

    @BeforeEach
    void setUp() {
        ship = new Ship(new Coordinates(1, 3), 3, Orientation.HORIZONTAL);
        decks.addAll(ship.getDecks().values());
    }

    @Test
    void isDamaged() {
        assertFalse(decks.get(0).isDamaged());
        assertFalse(decks.get(1).isDamaged());
        assertFalse(decks.get(2).isDamaged());
    }

    @Test
    void getCoordinates() {
        assertEquals(new Coordinates(1, 3), decks.get(0).getCoordinates());
        assertEquals(new Coordinates(2, 3), decks.get(1).getCoordinates());
        assertEquals(new Coordinates(3, 3), decks.get(2).getCoordinates());
    }

    @Test
    void setDamaged() {
        decks.get(0).setDamaged();
        decks.get(1).setDamaged();
        decks.get(2).setDamaged();
        assertTrue(decks.get(0).isDamaged());
        assertTrue(decks.get(1).isDamaged());
        assertTrue(decks.get(2).isDamaged());
    }

    @Test
    void getShipOwner() {
        for (Deck deck: decks) {
            assertEquals(ship, deck.getShipOwner());
        }
    }

    @Test
    void getDeckIntactStatus() {
        //decks are intact
        for (Deck deck: decks) {
            assertEquals(DeckStatus.INTACT, deck.getStatus());
        }
    }

    @Test
    void getDeckDamagedStatus() {
        //ship is damaged, decks first and third are damaged, second is intact
        decks.get(0).setDamaged();
        decks.get(2).setDamaged();
        assertEquals(DeckStatus.DAMAGED, decks.get(0).getStatus());
        assertEquals(DeckStatus.DAMAGED, decks.get(2).getStatus());
    }

    @Test
    void getDeckDestroyedStatus() {
        //ship is destroyed
        ship.setStatus(ShipStatus.DESTROYED);

        assertEquals(DeckStatus.DESTROYED, decks.get(0).getStatus());
        assertEquals(DeckStatus.DESTROYED, decks.get(1).getStatus());
        assertEquals(DeckStatus.DESTROYED, decks.get(2).getStatus());
    }
}