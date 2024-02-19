package src.java.main.DTO;

import src.java.main.Annotation.CalCulator;
import src.java.main.Annotation.Number1;
import src.java.main.Annotation.Number2;

public class Example {
    @Number1
    private int number1;
    @Number2
    private int number2;
    @CalCulator
    private String cal;

    public Example(int number1, int number2, String cal) {
        this.number1 = number1;
        this.number2 = number2;
        this.cal = cal;
    }
}
