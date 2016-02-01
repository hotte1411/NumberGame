package com.vk.hotte.model;

/**
 * Represents a player instance
 */
public class Player {
    /**
     * player name
     */
    private String name;

    /**
     * default constructor
     */
    public Player() {

    }

    /**
     * constructor with @param name
     *
     * @param name name of player
     */
    public Player(String name) {
        this.name = name;
    }

    /**
     * getter
     *
     * @return name of player
     */
    public String getName() {
        return name;
    }

    /**
     * setter
     *
     * @param name set value to player name variable
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * overrides Object's method hashCode
     *
     * @return hashCode of object, uses hashCode of name variable
     */
    @Override
    public int hashCode() {
        return getName().hashCode();
    }

    /**
     * overrides Object's method equals
     *
     * @param obj object with which needs to get equality
     * @return true if @param obj is Player and if it's name isn't null and if it's name equals with called Player's name,
     * false if not
     */
    @Override
    public boolean equals(Object obj) {
        return obj instanceof Player && this.getName() != null && ((Player) obj).getName() != null && ((Player) obj).getName().equals(this.getName());
    }
}
