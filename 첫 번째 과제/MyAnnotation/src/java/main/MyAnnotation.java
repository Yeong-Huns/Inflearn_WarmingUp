package src.java.main;

import src.java.main.DTO.Example;
import src.java.main.service.CalculatorService;

import java.util.Scanner;

public class MyAnnotation {
    public static void main(String[] args) throws IllegalAccessException {
        System.out.print("\n. ╱◥████◣\n" +
                "│田│▤╠╣▤│\n" +
                "╱◥████◣ ╱◥◣\n" +
                "╱◥◣║ ▤∩▤║║田│║\n" +
                "│田│◥███◣╱◥███◣\n" +
                "╱◥◣ ◥███◣ 田 ∩│▤║\n" +
                "╱◥◣│╱◥█◣║∩∩∩║◥███◣\n" +
                "║田 ││田│∩║ 田∩田 ║田∩田 ║\n");
        System.out.print("♪~ ♬ ♪♬~♪ ♪~ ♬ ♪♬~♪ ♪~ ♬ ♪♬~♪ ♪~ ♬ ♪\n");
        System.out.print("============콩순이 계산기=============\n");
        Scanner scan = new Scanner(System.in);
        System.out.print("숫자 1 입력 : ");
        int num1 = scan.nextInt();
        System.out.print("숫자 2 입력 : ");
        int num2 = scan.nextInt();
        System.out.print("[ADD, SUB, MUL, DIV] : ");
        String cal = scan.next();

        CalculatorService.MyCalculatorService(new Example(num1, num2, cal)); // 스캐너로 num1, num2, cal 값을 받아서 생성자로 Example생성 후 MyCalculatorService에 전달
        System.out.print("====================================\n");
        System.out.print("♪~ ♬ ♪♬~♪ ♪~ ♬ ♪♬~♪ ♪~ ♬ ♪♬~♪ ♪~ ♬ ♪\n");

    }
}
