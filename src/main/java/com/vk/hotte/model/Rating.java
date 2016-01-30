package com.vk.hotte.model;


public class Rating implements Comparable<Rating> {
    private String level;
    private String playerName;
    private int rating;

    public Rating(String level, String playerName) {
        this.level = level;
        this.playerName = playerName;
    }


    public int compareTo(Rating o) {
        return Integer.compare(this.rating, o.rating);
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getRating() {
        return rating;

    }

    public String getLevel() {
        return level;
    }

    public String getPlayerName() {
        return playerName;
    }

    @Override
    public String toString() {
        return level + "/" + playerName;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Rating && ((Rating)obj).level.equals(this.level) && ((Rating)obj).playerName.equals(this.playerName);
    }

    @Override
    public int hashCode() {
        return level.hashCode()*3 + playerName.hashCode()*7;
    }
}
