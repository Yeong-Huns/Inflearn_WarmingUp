package org.example;

@FunctionalInterface
interface MyFunctionalInterface{
    int sum(int a, int b);
}
public class functionalInterface1 {
    public static void main(String[] args) {
        MyFunctionalInterface Myfunction = (a, b) -> a + b;
        System.out.println(Myfunction.sum(15,17));
    }
}
