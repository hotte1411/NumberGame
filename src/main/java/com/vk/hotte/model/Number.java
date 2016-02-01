package com.vk.hotte.model;


import java.util.Random;

/**
 * This class represents the number, used in game
 */
public class Number {
    /**
     * primitive value in int, which sets by numberForGuess method
     */
    private int numberForGuess;

    /**
     * constructor, get @param level, used for set level of the game
     * and set random primitive value to numberForGuess by makeRandomNumber method
     *
     * @param level it'a inner enum class in Game class
     */
    public Number(Game.Level level) {
        this.numberForGuess = makeRandomNumber(level);
    }

    /**
     * getter
     *
     * @return primitive value of number
     */
    public int getNumberForGuess() {
        return this.numberForGuess;
    }

    /**
     * @param level used current level of game to get interval in which needs to get random number
     * @return random from 0-9 if level is EASY, from 0-99 if level is MEDIUM, from 0-999 if level is HARD
     */
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
