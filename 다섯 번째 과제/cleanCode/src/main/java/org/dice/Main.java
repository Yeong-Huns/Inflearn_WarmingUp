package org.dice;

public class Main {
    public static void main(String[] args) {
        Printer.printAsciiArt();
        // 범위 정하기
        int diceRange = InputScanner.Input("주사위의 범위를 정해주세요. (입력: 6 -> 1부터 6까지) : ");
        My_Dice dice = new My_Dice(diceRange); // 전달받은 숫자가 주사위 면의 수(숫자 갯수가 됨)
        int how_many = InputScanner.Input("주사위를 던질 횟수를 입력하세요: ");
        int[] gameResult = dice.rolling(how_many);
        Printer.printResults(gameResult);
    }
}