package org.webdice.core;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class DiceRollerTest {

    private DiceRoller diceRoller;
    private static final int MIN_BOUND = 1;
    private static final int MAX_D4_BOUND = 4;
    private static final int MAX_D6_BOUND = 6;
    private static final int MAX_D8_BOUND = 8;
    private static final int MAX_D10_BOUND = 10;
    private static final int MAX_D12_BOUND = 12;
    private static final int MAX_D20_BOUND = 20;

    @Before
    public void setUp() throws Exception {
        diceRoller = new DiceRoller();
    }

    @After
    public void tearDown() throws Exception {
        diceRoller = null;
    }

    @Test
    public void rollDiceD4() {
        int result = diceRoller.roll(4);

        assertTrue(result >= MIN_BOUND);
        assertTrue(result <= MAX_D4_BOUND);
    }

    @Test
    public void rollDiceD6() {
        int result = diceRoller.roll(6);

        assertTrue(result >= MIN_BOUND);
        assertTrue(result <= MAX_D6_BOUND);
    }

    @Test
    public void rollDiceD8() {
        int result = diceRoller.roll(8);

        assertTrue(result >= MIN_BOUND);
        assertTrue(result <= MAX_D8_BOUND);
    }

    @Test
    public void rollDiceD10() {
        int result = diceRoller.roll(10);

        assertTrue(result >= MIN_BOUND);
        assertTrue(result <= MAX_D10_BOUND);
    }

    @Test
    public void rollDiceD12() {
        int result = diceRoller.roll(12);

        assertTrue(result >= MIN_BOUND);
        assertTrue(result <= MAX_D12_BOUND);
    }

    @Test
    public void rollDiceD20() {
        int result = diceRoller.roll(20);

        assertTrue(result >= MIN_BOUND);
        assertTrue(result <= MAX_D20_BOUND);
    }
}