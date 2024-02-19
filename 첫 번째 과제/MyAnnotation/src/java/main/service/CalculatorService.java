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

        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(Number1.class)) {
                num1 = (int) field.getInt(object);
            } else if (field.isAnnotationPresent(Number2.class)) {
                num2 = (int) field.getInt(object);
            } else if (field.isAnnotationPresent(CalCulator.class)) {
                cal = field.get(object).toString();
            }
        }
        switch (cal) {
            case "ADD":
                System.out.println("덧셈 : " + (num1 + num2));
                break;
            case "SUB":
                System.out.println("뺄셈 : " + (num1 - num2));
                break;
            case "MUL":
                System.out.println("곱셈 : " + (num1 * num2));
                break;
            case "DIV":
                System.out.println("나눗셈 : " + (num1 / num2));
                break;
            default:
                System.out.println("오류");
                break;
        }
    }
}
