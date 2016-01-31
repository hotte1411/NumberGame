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
    public final static String DIRECTORY_PATH = System.getProperty("user.home") + File.separator + "Documents" + File.separator + "NumberGame";
    public final static String FILE_TO_SAVE = "rating.txt";
    private Game game;

    public RatingSaver(Game game) {
        this.game = game;
    }

    public boolean saveRating(String directoryPath, String fileToSave) {


        new File(directoryPath).mkdirs();
        String pathFileToSave = directoryPath + File.separator + fileToSave;

        ArrayList<Rating> allRatings = getAllRates(directoryPath, fileToSave);
        Rating currentRating = new Rating(game.getLevel(), game.getPlayer().getName());
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
            for (Rating rating : allRatings) {
                String line = rating + "/" + rating.getRating();
                lines.add(line);
            }
            Files.write(Paths.get(pathFileToSave), lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public ArrayList<Rating> getAllRates(String directoryPath, String fileToSave) {
        File fileWithRatings = new File(directoryPath + File.separator + fileToSave);
        ArrayList<Rating> allRatings = new ArrayList<Rating>();

        if (fileWithRatings.exists()) {
            try {
                Scanner scanner = new Scanner(new File(directoryPath + File.separator + fileToSave));
                while (scanner.hasNext()) {
                    String ratingString[] = scanner.next().split("/");
                    Rating tempRating = new Rating(Game.Level.valueOf(ratingString[0]), ratingString[1]);
                    tempRating.setRating(Integer.parseInt(ratingString[2]));
                    allRatings.add(tempRating);
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return allRatings;
    }
}
