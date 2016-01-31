package com.vk.hotte.model;


public class Player {
    private String name;

    public Player() {

    }

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Player && this.getName() != null && ((Player) obj).getName() != null && ((Player) obj).getName().equals(this.getName());
    }
}
