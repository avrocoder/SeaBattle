package com.github.avrocoder;

import com.github.avrocoder.validations.MoveValidation;

public class Main {
    public static void main(String[] args) {
        Player player1 = new Player("Player1", new ShipsField(), new ShotsField());
        Player player2 = new Player("Player2", new ShipsField(), new ShotsField());
        Game game = new Game(player1, player2);
        int k = 0;
        Player currentPlayer = player1;
        while(k < 2) {
            System.out.println(currentPlayer.getName() + ", place your ships");
            for (int i = 4; i > 0; i--) {
                for (int j = 0; j < 5 - i; j++) {
                    InputShip.input(currentPlayer.getShipsField(), i);
                    FieldPrinter.print(currentPlayer.getShipsField(),game.getOpponent(player1).getShotsField(),true);
                }
            }
            currentPlayer = game.getOpponent(currentPlayer);
            k++;
        }

        currentPlayer = player1;
        MoveValidation moveValidation;
        Coordinates coordinates;
        boolean isMoveValid;
        do {
            System.out.println("=== " + currentPlayer.getName() + " your move ===");
            do {
                System.out.println("My field");
                FieldPrinter.print(currentPlayer.getShipsField(),game.getOpponent(currentPlayer).getShotsField(),true);
                System.out.println("His field");
                FieldPrinter.print(game.getOpponent(currentPlayer).getShipsField(),currentPlayer.getShotsField(),false);

                coordinates= InputMove.input();
                moveValidation = new MoveValidation(coordinates, currentPlayer.getShotsField());

                isMoveValid = moveValidation.validate();
                if (!isMoveValid) {
                    System.out.println(moveValidation.getMessages());
                    System.out.println("Please, repeat your move");
                }

            } while(!isMoveValid);
            Move move = new Move(currentPlayer.getShotsField(), game.getOpponent(currentPlayer).getShipsField());
            move.make(coordinates);
            System.out.println("My field");
            FieldPrinter.print(currentPlayer.getShipsField(),game.getOpponent(currentPlayer).getShotsField(),true);
            System.out.println("His field");
            FieldPrinter.print(game.getOpponent(currentPlayer).getShipsField(),currentPlayer.getShotsField(),false);

            if (!move.isHit()) {
                currentPlayer = game.getOpponent(currentPlayer);
            } else {
                System.out.println("Great shot! One more shot... ");
            }
        } while(!currentPlayer.getShipsField().isAllShipsAreDestroyed()&&!game.getOpponent(currentPlayer).getShipsField().isAllShipsAreDestroyed());
        System.out.println("Congratulations! " + currentPlayer.getName() + " won!");
    }
}