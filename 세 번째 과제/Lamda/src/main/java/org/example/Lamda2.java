package org.example;

import java.util.function.Consumer;

public class Lamda2 {

    public static void print(Consumer<String> anyMessage, String str){
        anyMessage.accept(str);
    }
    
    public static void main(String[] args) {
        print((inflearn) -> System.out.println(inflearn), "Hello, inflearn");
    }
}
