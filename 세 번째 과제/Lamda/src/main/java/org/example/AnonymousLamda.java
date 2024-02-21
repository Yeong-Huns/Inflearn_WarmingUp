package org.example;

interface Calculator{
    int calculator(int a, int b);
}
public class AnonymousLamda {
    public static void main(String[] args) {
    Calculator anonymous = new Calculator() {
        @Override
        public int calculator(int a, int b) {
            return a + b;
        }
    };
    //-> 람다
    Calculator lamda = (a,b) -> {
        return a + b;
    };
    //-> short
    Calculator shortlamda = (a,b) -> a + b;
    //-> + methodReference
    Calculator methodReference = Integer::sum;
}
}