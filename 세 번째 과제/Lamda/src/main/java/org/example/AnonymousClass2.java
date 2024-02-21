package org.example;

interface Runners {
    public String study();
    public String homework();
}

public class AnonymousClass2 {
    public static void main(String[] args) {
        Runners student = new Runners() {
            @Override
            public String study() {
                return "인터페이스 익명 구현 객체를 공부해요";
            }

            @Override
            public String homework() {
                return "3일차 과제를 해요";
            }
        };
        System.out.println(student.study());
        System.out.println(student.homework());

    }
}
