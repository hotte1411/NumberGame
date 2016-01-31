package com.vk.hotte.model;

import org.junit.Assert;
import org.junit.Test;


public class GameTest {

    @Test
    public void testGetCountOfGuesses() throws Exception {
        Game game = new Game(Game.Level.EASY, new Player("hotte"));
        int actualCountOfGuesses = game.getCountOfGuesses();
        int expectedCountOfGuesses = 0;
        Assert.assertEquals(expectedCountOfGuesses, actualCountOfGuesses);
    }

    @Test
    public void testSetCountOfGuesses() throws Exception {
        Game game = new Game(Game.Level.MEDIUM, new Player("hotte"));
        game.setCountOfGuesses(5);
        int actualCountOfGuesses = game.getCountOfGuesses();
        int expectedCountOfGuesses = 5;
        Assert.assertEquals(expectedCountOfGuesses, actualCountOfGuesses);
    }

    @Test
    public void testSetNumber() throws Exception {
        Game game = new Game(Game.Level.EASY, new Player("hotte"));
        for (int index = 0; index < 100; ++index) {
            game.setNumber(new Number(Game.Level.EASY));
            int actualNumber = game.getNumber().getNumberForGuess();
            boolean isCorrect = actualNumber < 10;
            Assert.assertTrue(isCorrect);
        }

        game = new Game(Game.Level.MEDIUM, new Player("hotte"));
        for (int index = 0; index < 1000; ++index) {
            game.setNumber(new Number(Game.Level.MEDIUM));
            int actualNumber = game.getNumber().getNumberForGuess();
            boolean isCorrect = actualNumber < 100;
            Assert.assertTrue(isCorrect);
        }

        game = new Game(Game.Level.HARD, new Player("hotte"));
        for (int index = 0; index < 10000; ++index) {
            game.setNumber(new Number(Game.Level.HARD));
            int actualNumber = game.getNumber().getNumberForGuess();
            boolean isCorrect = actualNumber < 1000;
            Assert.assertTrue(isCorrect);
        }
    }

    @Test
    public void testSetPlayer() throws Exception {
        Game game = new Game(Game.Level.EASY, new Player("hotte"));
        game.setPlayer(new Player("hottest"));
        Player actualPlayer = game.getPlayer();
        Player expectedPlayer = new Player("hottest");
        Assert.assertEquals(expectedPlayer, actualPlayer);
    }

    @Test
    public void testSetLevel() throws Exception {
        Game game = new Game(Game.Level.EASY, new Player("hotte"));
        game.setLevel(Game.Level.HARD);
        Game.Level actualLevel = game.getLevel();
        Game.Level expectedLevel = Game.Level.HARD;
        Assert.assertEquals(expectedLevel, actualLevel);
    }

    @Test
    public void testGetNumber() throws Exception {
        Game game = new Game(Game.Level.EASY, new Player("hotte"));
        Number expectedNumber = new Number(Game.Level.EASY);
        game.setNumber(expectedNumber);
        Number actualNumber = game.getNumber();
        Assert.assertEquals(expectedNumber, actualNumber);

    }

    @Test
    public void testGetPlayer() throws Exception {
        Game game = new Game(Game.Level.EASY, new Player("hotte"));
        Player actualPlayer = game.getPlayer();
        Player expectedPlayer = new Player("hotte");
        Assert.assertEquals(expectedPlayer, actualPlayer);
    }

    @Test
    public void testGetLevel() throws Exception {
        Game game = new Game(Game.Level.EASY, new Player("hotte"));
        Game.Level actualLevel = game.getLevel();
        Game.Level expectedLevel = Game.Level.EASY;
        Assert.assertEquals(expectedLevel, actualLevel);
    }
}