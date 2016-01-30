package com.vk.hotte.model;


public class Game {

    private Number number;
    private Player player;
    private Level level;
    private int countOfGuesses;

    public int getCountOfGuesses() {
        return countOfGuesses;
    }

    public void setCountOfGuesses(int countOfGuesses) {
        this.countOfGuesses = countOfGuesses;
    }

    public Game(Level level) {
        this.number = new Number(level);
        this.level = level;
        this.countOfGuesses = 0;
        this.player = new Player();
    }

    public Number getNumber() {
        return number;
    }

    public Player getPlayer() {
        return player;
    }

    public Level getLevel() {
        return level;
    }

    public enum Level {
        EASY, MEDIUM, HARD
    }
}
