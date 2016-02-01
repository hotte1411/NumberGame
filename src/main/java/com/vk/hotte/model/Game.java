package com.vk.hotte.model;

/**
 * Represent Game instance
 */
public class Game {

    /**
     * number, used for guess by player
     */
    private Number number;

    /**
     * current Player instance
     */
    private Player player;

    /**
     * current Game level instance
     */
    private Level level;

    /**
     * count og guesses by player in current game
     */
    private int countOfGuesses;

    /**
     * getter
     *
     * @return count og guesses
     */
    public int getCountOfGuesses() {
        return countOfGuesses;
    }

    /**
     * setter
     *
     * @param countOfGuesses set count og guesses
     */
    public void setCountOfGuesses(int countOfGuesses) {
        this.countOfGuesses = countOfGuesses;
    }

    /**
     * constructor, sets number by constructor of Number(Game.Level level), level and player by passed parameters and countOfGuesses to 0
     *
     * @param level  level which needs to set up
     * @param player player which plays this game
     */
    public Game(Level level, Player player) {
        this.number = new Number(level);
        this.level = level;
        this.countOfGuesses = 0;
        this.player = player;
    }

    /**
     * setter
     *
     * @param number Number value needs to set up
     */
    public void setNumber(Number number) {
        this.number = number;
    }

    /**
     * setter
     *
     * @param player Player value needs to set up
     */
    public void setPlayer(Player player) {
        this.player = player;
    }

    /**
     * setter
     *
     * @param level Game level value needs to set pu
     */
    public void setLevel(Level level) {
        this.level = level;
    }

    /**
     * getter
     *
     * @return current Number object
     */
    public Number getNumber() {
        return number;
    }

    /**
     * getter
     *
     * @return current Player object
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * getter
     *
     * @return current enum value of Game Level
     */
    public Level getLevel() {
        return level;
    }

    /**
     * inner enum class with values of complexities used in Game
     */
    public enum Level {
        EASY, MEDIUM, HARD
    }
}
