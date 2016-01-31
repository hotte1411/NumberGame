package com.vk.hotte.controller;


import com.vk.hotte.model.Game;

public class WinnerChecker {

    Game game;

    public WinnerChecker(Game game) {
        this.game = game;
    }

    public int compareGuess(int guessNumber) {
        int numberForGuess = game.getNumber().getNumberForGuess();

        if(numberForGuess < guessNumber) {
            return 1;
        }

        if(numberForGuess > guessNumber) {
            return -1;
        }

        return 0;
    }
}
