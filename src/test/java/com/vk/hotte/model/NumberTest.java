package com.vk.hotte.model;

import org.junit.Test;


public class NumberTest {
    @Test
    public void testMakeRandomNumberLevelOne() throws Exception {
        for (int i = 0; i < 500; ++i) {
            Number number = new Number(Game.Level.EASY);
            boolean comparison = (number.getNumberForGuess() < 10);
            assert comparison;
        }
    }

    @Test
    public void testMakeRandomNumberLevelTwo() throws Exception {
        for (int i = 0; i < 5000; ++i) {
            Number number = new Number(Game.Level.MEDIUM);
            boolean comparison = (number.getNumberForGuess() < 100);
            assert comparison;
        }
    }

    @Test
    public void testMakeRandomNumberLevelThree() throws Exception {
        for (int i = 0; i < 50000; ++i) {
            Number number = new Number(Game.Level.HARD);
            boolean comparison = (number.getNumberForGuess() < 1000);
            assert comparison;
        }
    }

}
