package org.example;

import java.util.function.Consumer;

public class Lamda {
    public static void main(String[] args) {
        Consumer<String> printMessage = (AnyString) -> System.out.println(AnyString);
        printMessage.accept("Hello WarmingUp Club!");
    }
}
