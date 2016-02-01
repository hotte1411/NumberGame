package com.vk.hotte.view;

import com.vk.hotte.controller.RatingSaver;
import com.vk.hotte.controller.WinnerChecker;
import com.vk.hotte.model.Game;
import com.vk.hotte.model.Player;
import com.vk.hotte.model.Rating;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Console view of game
 */
public class ConsoleView {
    /**
     * current Game instance
     */
    private static Game game;

    /**
     * player's guess
     */
    private static int guessNumber;
    /**
     * RatingSaver instance
     */
    private static RatingSaver ratingSaver;
    /**
     * lover guess by player
     */
    private static int lowerGuess;
    /**
     * higher guess by player
     */
    private static int higherGuess;

    /**
     * entry point of application
     *
     * @param args arguments with which application runs
     */
    public static void main(String[] args) {

        Player player = new Player();
        game = new Game(askForLevel(), player);
        WinnerChecker winnerChecker = new WinnerChecker(game);
        ratingSaver = new RatingSaver(game);

        lowerGuess = 0;
        switch (game.getLevel()) {
            case EASY:
                higherGuess = 9;
                break;
            case MEDIUM:
                higherGuess = 99;
                break;
            case HARD:
                higherGuess = 999;
                break;
        }

        do {
            guessNumber = askForGuessNumber();
            game.setCountOfGuesses(game.getCountOfGuesses() + 1);
            int checkNumber = winnerChecker.compareGuess(guessNumber);

            switch (checkNumber) {
                case 1:
                    System.out.println("Бери ниже!");
                    if (higherGuess >= guessNumber) {
                        higherGuess = guessNumber - 1;
                    }
                    break;
                case -1:
                    System.out.println("Бери выше!");
                    if (lowerGuess <= guessNumber) {
                        lowerGuess = guessNumber + 1;
                    }
                    break;
            }

        } while (winnerChecker.compareGuess(guessNumber) != 0);

        System.out.println("ОТЛИЧНО!! Количество попыток: " + game.getCountOfGuesses());
        game.getPlayer().setName(askForPlayerName());
        ratingSaver.saveRating(RatingSaver.DIRECTORY_PATH, RatingSaver.FILE_TO_SAVE);
        showRating();
    }

    /**
     * asked player to enter level of game (1 or 2 or 3)
     *
     * @return Game.Level.EASY if enters 1, Game.Level.MEDIUM if enters 2, Game.Level.HARD if enters 3,
     * Game.Level.EASY if enters 1 in any other ints, asked to enter number if not number is enters
     */
    public static Game.Level askForLevel() {
        System.out.print("Выберите уровень сложности (1,2,3): ");
        int level = 0;
        while (level == 0) {
            try {
                Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
                level = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("ВВЕДИТЕ ЧИСЛО (1,2,3)");
            }
        }
        switch (level) {
            case 3:
                return Game.Level.HARD;
            case 2:
                return Game.Level.MEDIUM;
            case 1:
                return Game.Level.EASY;
            default:
                return Game.Level.EASY;
        }
    }

    /**
     * asked player to enter guess number, if not number is entered, re-asked to enter tne number
     *
     * @return player's guess
     */
    private static int askForGuessNumber() {
        String inputNumberText = "Введите число от " + lowerGuess + " до " + higherGuess + ": ";
        System.out.print(inputNumberText);

        Integer number = null;
        while (number == null) {
            try {
                Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
                number = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("ВВЕДИТЕ ЧИСЛО");
            }
        }
        guessNumber = number;
        return number;
    }

    /**
     * asked player to enter his nickname
     *
     * @return player's nickname
     */
    private static String askForPlayerName() {
        System.out.print("Введите имя игрока: ");
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        return scanner.next();
    }

    /**
     * shows all ratings by current Game.Level in console
     */
    private static void showRating() {
        System.out.println(" - - рейтинг всех игроков - - ");
        ArrayList<Rating> allRatings = ratingSaver.getAllRates(RatingSaver.DIRECTORY_PATH, RatingSaver.FILE_TO_SAVE);
        Game.Level level = game.getLevel();
        for (Rating rating : allRatings) {
            if (rating.getLevel().equals(level)) {
                System.out.printf("|| %17s || %3d ||\n", rating.getPlayerName(), rating.getRating());
            }
        }
    }
}
