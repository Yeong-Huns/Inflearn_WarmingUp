package org.dice;

public class Printer {
    public final static String hr_line = "⋆｡♡ﾟ☁\uFE0E ⋆｡ ﾟ☁\uFE0E ﾟ｡♡⋆｡⋆｡♡ﾟ☁\uFE0E ⋆｡♡ﾟ☁\uFE0E ⋆｡ ﾟ☁\uFE0E ﾟ｡♡⋆｡⋆｡♡ﾟ☁\uFE0E ⋆｡ ﾟ☁\uFE0E ﾟ｡♡⋆｡⋆｡♡ﾟ☁\uFE0E ⋆｡ ﾟ☁\uFE0E ﾟ｡♡⋆｡ ⋆｡♡ﾟ☁\uFE0E ⋆｡ ﾟ☁\uFE0E ﾟ｡♡⋆｡⋆｡♡ﾟ☁\uFE0E ";
    public static void printAsciiArt(){
        System.out.println("╭ ◜◝ ͡ ◜◝ ͡ ◜◝ ͡ ◜◝ ͡ ◜◝ ͡ ◜◝ ͡ ◜◝ ͡ ◜◝ ͡ ◜◝ ͡ ◜◝ ͡ ◜◝ ͡ ◜◝╮\n" + "\t"+"\t"+"\t"+"\t"+"Rolling Dice with Inflearn Warming Up Club! "+
                "\n" +
                "╰ ◟◞ ͜ ◟◞ ͜ ◟◞ ͜ ◟◞ ͜ ◟◞ ͜ ◟◞ ͜ ◟◞ ͜ ◟◞ ͜ ◟◞ ͜ ◟◞ ͜ ◟◞ ͜ ◟◞ ╯\n" +
                "O\n" +
                "°\n" +
                "/}__/}\n" +
                "( • ▼•)\n" + hr_line);
    } // 1.아스키아트를 그리는 기능

    public static void printResults(int[] gameResult) {
        for (int i = 0; i < gameResult.length; i++) {
            System.out.print("[ "+(i + 1) +" ] "+ "나온 횟수 : " + gameResult[i] + "\t" + "\t");
            if(i == gameResult.length - 1) System.out.println("\n"+hr_line);
            if(i % 4 == 3) System.out.println();
        }
    } // 2.게임종료 후 결과를 출력하는 기능
}
