package com.vk.hotte.controller;


import com.vk.hotte.model.Game;
import com.vk.hotte.model.Rating;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class RatingSaver {
    Game game;
    ArrayList<Rating> allRatings = new ArrayList<Rating>();
    String pathFileToSave = "C://fortest/rating.txt";

    public RatingSaver(Game game) {
        this.game = game;
    }

    public boolean saveRating() {

        allRatings = getAllRates();
        Rating currentRating = new Rating(game.getLevel().toString(), game.getPlayer().getName());
        currentRating.setRating(game.getCountOfGuesses());
        if (allRatings.contains(currentRating)) {
            if (currentRating.compareTo(allRatings.get(allRatings.indexOf(currentRating))) < 0) {
                allRatings.get(allRatings.indexOf(currentRating)).setRating(game.getCountOfGuesses());
            }
        } else {
            allRatings.add(currentRating);
        }
        try {
            List<String> lines = new ArrayList<String>();
            for (Rating rating: allRatings) {
                String line = rating + "/" + rating.getRating();
                lines.add(line);
            }
            Files.write(Paths.get(pathFileToSave), lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public ArrayList<Rating> getAllRates() {
        ArrayList<Rating> allRatings = new ArrayList<Rating>();
        try {
            Scanner scanner = new Scanner(new File(pathFileToSave));
            while (scanner.hasNext()) {
                String ratingString[] = scanner.next().split("/");
                Rating tempRating = new Rating(ratingString[0], ratingString[1]);
                tempRating.setRating(Integer.parseInt(ratingString[2]));
                allRatings.add(tempRating);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return allRatings;
    }
}
