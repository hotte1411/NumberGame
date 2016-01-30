package com.vk.hotte.controller;


import com.vk.hotte.model.Game;

public class WinnerChecker {

    Game game;

    public WinnerChecker(Game game) {
        this.game = game;
    }

    public boolean isPlayerWin(int number) {
        return game.getNumber().getNumberForGuess() == number;
    }
}
