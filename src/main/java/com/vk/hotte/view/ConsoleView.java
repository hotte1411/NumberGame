package com.vk.hotte.view;

import com.vk.hotte.controller.RatingSaver;
import com.vk.hotte.controller.WinnerChecker;
import com.vk.hotte.model.Game;
import com.vk.hotte.model.Rating;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;


public class ConsoleView {

    private static Game game;
    private static int guessNumber;
    private static RatingSaver ratingSaver;
    private static int lowerGuess;
    private static int higherGuess;

    public static void main(String[] args) {

        game = new Game(askForLevel());
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

            if (guessNumber > game.getNumber().getNumberForGuess()) {
                System.out.println("Бери ниже!");
                if (higherGuess >= guessNumber) {
                    higherGuess = guessNumber - 1;
                }
            } else if (guessNumber < game.getNumber().getNumberForGuess()){
                System.out.println("Бери выше!");
                if (lowerGuess <= guessNumber) {
                    lowerGuess = guessNumber + 1;
                }
            }
        } while (!winnerChecker.isPlayerWin(guessNumber));

        System.out.println("ОТЛИЧНО!! Количество попыток: " + game.getCountOfGuesses());
        game.getPlayer().setName(askForPlayerName());
        ratingSaver.saveRating();
        showRating();
    }

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

    private static int askForGuessNumber() {
        String inputNumberText = "Введите число от " + lowerGuess + " до " + higherGuess + ": ";
        System.out.print(inputNumberText);

        int number = 0;
        while (number == 0) {
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

    private static String askForPlayerName() {
        System.out.print("Введите имя игрока: ");
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        return scanner.next();
    }

    private static void showRating() {
        System.out.println(" - - рейтинг всех игроков - - ");
        ArrayList<Rating> allRatings = ratingSaver.getAllRates();
        String level = game.getLevel().toString();
        for (Rating rating : allRatings) {
            if (rating.getLevel().equals(level)) {
                System.out.printf("|| %17s || %3d ||\n", rating.getPlayerName(), rating.getRating());
            }
        }
    }
}