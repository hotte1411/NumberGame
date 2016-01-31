package com.vk.hotte.controller;

import com.vk.hotte.model.Game;
import com.vk.hotte.model.Player;
import com.vk.hotte.model.Rating;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;


public class RatingSaverTest {

    @Test
    public void testSaveRating() throws Exception {
        Game game = new Game(Game.Level.EASY, new Player("hotte"));
        RatingSaver ratingSaver = new RatingSaver(game);
        game.setCountOfGuesses(3);
        ratingSaver.saveRating("E://test/", "rating.txt");

        ArrayList<Rating> ratings = ratingSaver.getAllRates("E://test/", "rating.txt");
        Rating actual = ratings.get(0);
        Rating expected = new Rating(Game.Level.EASY, "hotte");
        expected.setRating(3);
        Assert.assertEquals(expected, actual);
        int actualRatingValue = actual.getRating();
        int expectedRatingValue = 3;
        Assert.assertEquals(expectedRatingValue,actualRatingValue);

        game.setCountOfGuesses(4);
        ratingSaver.saveRating("E://test/", "rating.txt");
        ratings = ratingSaver.getAllRates("E://test/", "rating.txt");
        actual = ratings.get(0);
        Assert.assertEquals(expected, actual);
        actualRatingValue = actual.getRating();
        expectedRatingValue = 3;
        Assert.assertEquals(expectedRatingValue, actualRatingValue);

        game.setCountOfGuesses(1);
        ratingSaver.saveRating("E://test/", "rating.txt");
        ratings = ratingSaver.getAllRates("E://test/", "rating.txt");
        actual = ratings.get(0);
        Assert.assertEquals(expected, actual);
        actualRatingValue = actual.getRating();
        expectedRatingValue = 1;
        Assert.assertEquals(expectedRatingValue, actualRatingValue);
    }

    @Test
    public void testGetAllRates() throws Exception {
        Game game = new Game(Game.Level.EASY, new Player("hotte"));
        RatingSaver ratingSaver = new RatingSaver(game);
        game.setCountOfGuesses(4);
        ratingSaver.saveRating("E://test/secondTest/", "rating.txt");

        game = new Game(Game.Level.HARD, new Player("hotte"));
        ratingSaver = new RatingSaver(game);
        game.setCountOfGuesses(2);
        ratingSaver.saveRating("E://test/secondTest/", "rating.txt");

        game = new Game(Game.Level.EASY, new Player("hottest"));
        ratingSaver = new RatingSaver(game);
        game.setCountOfGuesses(2);
        ratingSaver.saveRating("E://test/secondTest/", "rating.txt");

        ArrayList<Rating> ratings = ratingSaver.getAllRates("E://test/secondTest/", "rating.txt");
        Rating actualRating1 = ratings.get(0);
        Rating actualRating2 = ratings.get(1);
        Rating actualRating3 = ratings.get(2);
        int actualRatingValue1 = actualRating1.getRating();
        int actualRatingValue2 = actualRating2.getRating();
        int actualRatingValue3 = actualRating3.getRating();
        Rating expectedRating1 = new Rating(Game.Level.EASY, "hotte");
        Rating expectedRating2 = new Rating(Game.Level.HARD, "hotte");
        Rating expectedRating3 = new Rating(Game.Level.EASY, "hottest");
        expectedRating1.setRating(4);
        expectedRating2.setRating(2);
        expectedRating3.setRating(2);
        int expectedRatingValue1 = 4;
        int expectedRatingValue2 = 2;
        int expectedRatingValue3 = 2;

        Assert.assertEquals(expectedRating1, actualRating1);
        Assert.assertEquals(expectedRating2, actualRating2);
        Assert.assertEquals(expectedRating3, actualRating3);
        Assert.assertEquals(expectedRatingValue1, actualRatingValue1);
        Assert.assertEquals(expectedRatingValue2, actualRatingValue2);
        Assert.assertEquals(expectedRatingValue3, actualRatingValue3);

    }
}