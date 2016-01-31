package com.vk.hotte.model;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;


public class PlayerTest {

    @Test
    public void testGetName() throws Exception {
        Player player = new Player("hotte");
        String actualName = player.getName();
        String expectedName = "hotte";
        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    public void testSetName() throws Exception {
        Player player = new Player();
        player.setName("hotte");
        String actualName = player.getName();
        String expectedName = "hotte";
        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    public void testHashCode() throws Exception {
        Player player1 = new Player("hotte");
        Player player2 = new Player("hotte");
        Assert.assertEquals(player1.hashCode(), player2.hashCode());

        Player player3 = new Player("hottest");
        Assert.assertNotSame(player1.hashCode(), player3.hashCode());
    }

    @Test
    public void testEquals() throws Exception {
        Player player1 = new Player("hotte");
        Player player2 = new Player("hotte");
        Assert.assertEquals(player1, player2);

        Player player3 = new Player("hottest");
        Assert.assertNotSame(player1, player3);
    }
}