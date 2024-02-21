package org.example;

import java.util.function.Consumer;

public class Lamda3 {

    public static Consumer<String> printAnyMessage(){
        return System.out::println;
    }

    public static void main(String[] args) {
        Consumer<String> MyMessage = printAnyMessage();
        MyMessage.accept("Hello! runners!");
    }

}
