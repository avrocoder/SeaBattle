package com.github.avrocoder;

import java.util.Scanner;

public class InputMove {
    public static Coordinates input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Your move");
        System.out.println("Input coordinates X");
        int x = scanner.nextInt();
        System.out.println("Input coordinates Y");
        int y = scanner.nextInt();
        return new Coordinates(x, y);
    }
}
