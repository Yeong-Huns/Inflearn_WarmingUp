package org.example;

import java.io.Console;

//부모 클래스
class WarmingUp{
    public String study(){
        return "공부를 열심히 한다.";
    }
}
class Inflearn{
    WarmingUp student = new WarmingUp(){
        public String study(){
            return "3일차 과제를 한다.";
        }
    };
    public String ToDoList(){
       return student.study();
    }

    public void method(WarmingUp runners){
        runners.study();
    }
}

public class AnonymousClass1 {
    public static void main(String[] args) {
        WarmingUp runners = new WarmingUp(){
        @Override
        public String study(){
            return "익명 클래스에 대해 공부한다.";
        }
        };
        System.out.println(runners.study()); //익명 클래스 사용
        Inflearn student1 = new Inflearn();
        System.out.println(student1.ToDoList());
        Inflearn me = new Inflearn();
        System.out.println();
        me.method(new WarmingUp(){
            public String study(){
                return "생각보다 힘들어요";
            }
        });
    }

}
