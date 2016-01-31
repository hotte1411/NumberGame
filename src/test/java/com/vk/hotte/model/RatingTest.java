package com.vk.hotte.model;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;


public class RatingTest {

    @Test
    public void testCompareToWhenMore() throws Exception {
        Rating rating1 = new Rating(Game.Level.EASY, "hotte");
        Rating rating2 = new Rating(Game.Level.EASY, "hotte");
        rating1.setRating(3);
        rating2.setRating(5);
        int comparing = rating2.compareTo(rating1);
        assert comparing == 1;
    }

    @Test
    public void testCompareToWhenLess() throws Exception {
        Rating rating1 = new Rating(Game.Level.EASY, "hotte");
        Rating rating2 = new Rating(Game.Level.EASY, "hotte");
        rating1.setRating(8);
        rating2.setRating(5);
        int comparing = rating2.compareTo(rating1);
        assert comparing == -1;
    }

    @Test
    public void testCompareToWhenSame() throws Exception {
        Rating rating1 = new Rating(Game.Level.EASY, "hotte");
        Rating rating2 = new Rating(Game.Level.EASY, "hotte");
        rating1.setRating(8);
        rating2.setRating(8);
        int comparing = rating2.compareTo(rating1);
        assert comparing == 0;
    }

    @Test
    public void testEqualsWhenEquals() throws Exception {
        Rating rating1 = new Rating(Game.Level.EASY, "hotte");
        Rating rating2 = new Rating(Game.Level.EASY, "hotte");
        Assert.assertEquals(rating1, rating2);
    }

    @Test
    public void testEqualsWhenNotEqualsByLevel() throws Exception {
        Rating rating1 = new Rating(Game.Level.HARD, "hotte");
        Rating rating2 = new Rating(Game.Level.EASY, "hotte");
        Assert.assertNotSame(rating1, rating2);
    }

    @Test
    public void testEqualsWhenNotEqualsByName() throws Exception {
        Rating rating1 = new Rating(Game.Level.HARD, "hotte");
        Rating rating2 = new Rating(Game.Level.HARD, "hottest");
        Assert.assertNotSame(rating1, rating2);
    }

    @Test
    public void testHashCodeWhenSameObjects() throws Exception {
        Rating rating1 = new Rating(Game.Level.EASY, "hotte");
        Rating rating2 = new Rating(Game.Level.EASY, "hotte");
        Assert.assertEquals(rating1.hashCode(), rating2.hashCode());
    }

    @Test
    public void testHashCodeWhenNotSameObjectsByLevel() throws Exception {
        Rating rating1 = new Rating(Game.Level.EASY, "hotte");
        Rating rating2 = new Rating(Game.Level.HARD, "hotte");
        Assert.assertNotSame(rating1.hashCode(), rating2.hashCode());
    }

    @Test
    public void testHashCodeWhenNotSameObjectsByName() throws Exception {
        Rating rating1 = new Rating(Game.Level.EASY, "hotte");
        Rating rating2 = new Rating(Game.Level.EASY, "hottest");
        Assert.assertNotSame(rating1.hashCode(), rating2.hashCode());
    }

    @Test
    public void testSetRating() throws Exception {
        Rating rating = new Rating(Game.Level.EASY, "hotte");
        rating.setRating(5);
        int actualRatingValue = rating.getRating();
        int expectedRatingValue = 5;
        Assert.assertEquals(expectedRatingValue, actualRatingValue);
    }

    @Test
    public void testGetRating() throws Exception {
        Rating rating = new Rating(Game.Level.EASY, "hotte");
        rating.setRating(5);
        int actualRatingValue = rating.getRating();
        int expectedRatingValue = 5;
        Assert.assertEquals(expectedRatingValue, actualRatingValue);
    }

    @Test
    public void testGetLevel() throws Exception {
        Rating rating = new Rating(Game.Level.HARD, "hotte");
        Game.Level actualLevel = rating.getLevel();
        Game.Level expectedLevel = Game.Level.HARD;
        Assert.assertEquals(expectedLevel, actualLevel);

        rating = new Rating(Game.Level.MEDIUM, "hotte");
        actualLevel = rating.getLevel();
        expectedLevel = Game.Level.MEDIUM;
        Assert.assertEquals(expectedLevel, actualLevel);

        rating = new Rating(Game.Level.EASY, "hotte");
        actualLevel = rating.getLevel();
        expectedLevel = Game.Level.EASY;
        Assert.assertEquals(expectedLevel, actualLevel);
    }

    @Test
    public void testGetPlayerName() throws Exception {
        Rating rating = new Rating(Game.Level.MEDIUM, "hottest");
        String actualName = rating.getPlayerName();
        String expectedName = "hottest";
        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    public void testToString() throws Exception {
        Rating rating = new Rating(Game.Level.HARD, "hotte");
        String actualToString = rating.toString();
        String expectedToSting = "HARD/hotte";
        Assert.assertEquals(expectedToSting, actualToString);
    }
}