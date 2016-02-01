package com.vk.hotte.controller;


import com.vk.hotte.model.Game;

/**
 * Class controller used for compare numbers and check is player win or not by every guess.
 */
public class WinnerChecker {

    /**
     * instance of current Game
     */
    Game game;

    /**
     * constructor
     *
     * @param game current game
     */
    public WinnerChecker(Game game) {
        this.game = game;
    }

    /**
     * used for compare numbers and check is player win or not by every guess
     *
     * @param guessNumber player's guess number
     * @return 0 if player's guess is equal with number in Game, 1 if player's guess more than number in game, -1 if player guess less than number in game
     */
    public int compareGuess(int guessNumber) {
        int numberForGuess = game.getNumber().getNumberForGuess();

        if (guessNumber > numberForGuess) {
            return 1;
        }
        if (guessNumber < numberForGuess) {
            return -1;
        }
        return 0;
    }
}
