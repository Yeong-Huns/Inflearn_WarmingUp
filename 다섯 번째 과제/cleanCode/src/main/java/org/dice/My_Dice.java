package org.dice;

public class My_Dice {
    private final int diceRange;
    public My_Dice(int diceRange) {
        this.diceRange = diceRange;
    }
    public int[] rolling(int how_many) {
        int[] gameResult = new int[diceRange];
        for (int i = 0; i < how_many; i++) {
            int randomNumber = (int)(Math.random()*diceRange);
            gameResult[randomNumber]++;
        }
        return gameResult;
    }
}
