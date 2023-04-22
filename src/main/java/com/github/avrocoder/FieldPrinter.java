package com.github.avrocoder;

public class FieldPrinter {
    public static void print(ShipsField shipsField, ShotsField shotsField, boolean showIntactDeck) {
        System.out.print("\t");
        for (int i = 0; i < shipsField.getWidth(); i++) {
            System.out.print(i + "\t");
        }
        System.out.println();
        for (int i = 0; i < shipsField.getHeight(); i++) {
            System.out.print(i + "\t");
            for (int j = 0; j < shipsField.getWidth(); j++) {
                if (shipsField.getField().containsKey(new Coordinates(j, i))) {
                    DeckStatus deckStatus = shipsField.getField().get(new Coordinates(j, i)).getStatus();
                    if(deckStatus == DeckStatus.INTACT) {
                        if (!showIntactDeck) {
                            System.out.print("\t");
                        } else {
                            System.out.print(deckStatus.getImage() + "\t");
                        }
                    } else {
                        System.out.print(deckStatus.getImage() + "\t");
                    }
                } else {
                    if (shotsField.getField().containsKey(new Coordinates(j, i))) {
                        System.out.print(" . " + "\t");
                    } else {
                        System.out.print("\t");
                    }
                }
            }
            System.out.println();
        }
    }
}
