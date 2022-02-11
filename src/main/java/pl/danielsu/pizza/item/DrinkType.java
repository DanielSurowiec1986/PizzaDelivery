package pl.danielsu.pizza.item;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum DrinkType {
    COLA, SOK, PIWO;

    private static final List<DrinkType> VALUES =
            Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static DrinkType randomDrinkType() {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}

