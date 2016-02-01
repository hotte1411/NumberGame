package com.vk.hotte.model;


import javax.annotation.Nonnull;

/**
 * Represents rating of players in game
 */
public class Rating implements Comparable<Rating> {

    /**
     * level of game
     */
    private Game.Level level;

    /**
     * name of player
     */
    private String playerName;

    /**
     * rating of current player
     */
    private int rating;

    /**
     * constructor with to parameters
     *
     * @param level      for set current game level
     * @param playerName gor set current player
     */
    public Rating(Game.Level level, String playerName) {
        this.level = level;
        this.playerName = playerName;
    }


    /**
     * overrides compareTo method of Comparable interface
     *
     * @param o Rating object with which needs to compare calling Rating object
     * @return 0 if ratings are equals, 1 if current rating higher than the passed by param, -1 if  current rating lower
     */
    public int compareTo(@Nonnull Rating o) {
        return Integer.compare(this.rating, o.rating);
    }

    /**
     * setter, set value of rating
     *
     * @param rating pass value of rating
     */
    public void setRating(int rating) {
        this.rating = rating;
    }

    /**
     * getter
     *
     * @return value of rating
     */
    public int getRating() {
        return rating;
    }

    /**
     * getter
     *
     * @return game level of current rating
     */
    public Game.Level getLevel() {
        return level;
    }

    /**
     * getter
     *
     * @return player name of current rating
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * overrides Object's toString method
     *
     * @return "level/playerName" representation of Rating object
     */
    @Override
    public String toString() {
        return level + "/" + playerName;
    }

    /**
     * overrides Object's equals method
     *
     * @param obj object with which needs to get equality
     * @return true if obj is instance of Rating and it's level equals with calling object's level and if it's player name equals with calling object's player name,
     * false if not
     */
    @Override
    public boolean equals(Object obj) {
        return obj instanceof Rating && ((Rating) obj).level.equals(this.level) && ((Rating) obj).playerName.equals(this.playerName);
    }

    /**
     * overrides Object's hashCode method
     *
     * @return hashCode of object, uses hashCode of level value and hashCode playerName value
     */
    @Override
    public int hashCode() {
        return level.hashCode() * 3 + playerName.hashCode() * 7;
    }
}
