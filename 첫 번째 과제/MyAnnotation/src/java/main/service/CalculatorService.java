package src.java.main.service;

import src.java.main.Annotation.CalCulator;
import src.java.main.Annotation.Number1;
import src.java.main.Annotation.Number2;

import java.lang.reflect.Field;

public class CalculatorService {

    public static void MyCalculatorService(Object object) throws IllegalAccessException {
        int num1 = 0;
        int num2 = 0;
        String cal = "";

        Field[] fields = object.getClass().getDeclaredFields(); //객체를 받아서 해당 필드(DTO.Example.num1, DTO.Example.num2, DTO.Example.cal)을 for문으로 조회
        for (Field field : fields) {
            field.setAccessible(true); //붙이지 않으면 AccessException 발생 (private 변수에 접근할 수 있게 해줌)
            if (field.isAnnotationPresent(Number1.class)) {
                num1 = field.getInt(object);  //@Number1 어노테이션이 붙어있으면 getInt로 필드 값을 가져옴
            } else if (field.isAnnotationPresent(Number2.class)) {
                num2 = field.getInt(object); //@Number2 어노테이션이 붙어있으면 getInt로 필드 값을 가져옴
            } else if (field.isAnnotationPresent(CalCulator.class)) {
                cal = field.get(object).toString(); //@cal 어노테이션이 붙어있으면 객체를 toString으로 로 필드 값을 가져옴
            }
        }
        switch (cal) {
            case "ADD": //cal이 ADD 일 경우
                System.out.println("덧셈 : " + (num1 + num2));
                break;
            case "SUB": //cal이 SUB 일 경우
                System.out.println("뺄셈 : " + (num1 - num2));
                break;
            case "MUL": //cal이 MUL 일 경우
                System.out.println("곱셈 : " + (num1 * num2));
                break;
            case "DIV": //cal이 DIV 일 경우
                System.out.println("나눗셈 : " + (num1 / num2));
                break;
            default:
                System.out.println("오류");
                break;
        }
    }
}
