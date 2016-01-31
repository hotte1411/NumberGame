package com.vk.hotte.controller;

import com.vk.hotte.model.Game;
import com.vk.hotte.model.Player;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;


public class WinnerCheckerTest {

    @Test
    public void testCompareGuess() throws Exception {

        Game game = new Game(Game.Level.EASY, new Player());
        WinnerChecker winnerChecker = new WinnerChecker(game);

        int actualNumber = game.getNumber().getNumberForGuess();
        Assert.assertTrue(winnerChecker.compareGuess(actualNumber) == 0);
        Assert.assertTrue(winnerChecker.compareGuess(actualNumber+1) == 1);
        Assert.assertTrue(winnerChecker.compareGuess(actualNumber-1) == -1);
    }
}