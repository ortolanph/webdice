package org.webdice.core;

import java.util.Random;
import java.util.function.Function;

public class DiceRoller {
    public int roll(int faces) {
        return rollDice.apply(faces);
    }

    private Function<Integer, Integer> rollDice = r -> { return getRollingResult(r); };

    private Integer getRollingResult(int faces) {
        Random dice = new Random();
        return (dice.nextInt(faces) + 1);
    }
}
