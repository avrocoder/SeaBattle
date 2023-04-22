package com.github.avrocoder;

public class Game {
    Player player1;
    Player player2;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public Player getOpponent(Player player) {
        return (player == player1) ? player2 : player1;
    }
}
