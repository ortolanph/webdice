package org.webdice.core;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class DiceRollerTest {

    private DiceRoller diceRoller;

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

        System.out.println("Result is " + result);

        assertTrue(result >= 1);
        assertTrue(result <= 4);
    }
}