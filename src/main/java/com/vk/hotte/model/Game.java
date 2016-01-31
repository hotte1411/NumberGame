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

    public Game(Level level, Player player) {
        this.number = new Number(level);
        this.level = level;
        this.countOfGuesses = 0;
        this.player = player;
    }

    public void setNumber(Number number) {
        this.number = number;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setLevel(Level level) {
        this.level = level;
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
