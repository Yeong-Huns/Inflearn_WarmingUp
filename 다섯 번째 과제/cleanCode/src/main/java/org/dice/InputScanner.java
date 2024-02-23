package org.dice;

import java.util.Scanner;

public class InputScanner {
    public static int Input(String message) {
        System.out.print(message);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
