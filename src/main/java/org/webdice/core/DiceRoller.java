package org.webdice.core;

import java.util.Random;
import java.util.function.Function;

/**
 * Created by 27975700819 on 06/11/15.
 */
public class DiceRoller {
    public int roll(int faces) {
        return rollDice.apply(faces);
    }

    private Function<Integer, Integer> rollDice = r -> { return getRollingResult(r); };

    private Integer getRollingResult(int faces) {
        Random dice = new Random();
        return dice.nextInt(faces);
    }
}
