package com.vk.hotte.model;


import java.util.Random;

public class Number {
    private int numberForGuess;

    public Number(Game.Level level) {
        this.numberForGuess = makeRandomNumber(level);
    }

    public int getNumberForGuess() {
        return this.numberForGuess;
    }

    private static int makeRandomNumber(Game.Level level) {
        Random random = new Random();
        int randomInt;
        switch (level) {
            case EASY:
                randomInt = random.nextInt(9);
                break;
            case MEDIUM:
                randomInt = random.nextInt(99);
                break;
            case HARD:
                randomInt = random.nextInt(999);
                break;
            default:
                randomInt = 0;
        }
        return randomInt;
    }
}
