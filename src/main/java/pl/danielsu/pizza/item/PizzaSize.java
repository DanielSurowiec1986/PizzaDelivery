package pl.danielsu.pizza.item;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum PizzaSize {
    SMALL, MEDIUM, LARGE;

    private static final List<PizzaSize> VALUES =
            Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static PizzaSize randomPizzaSize() {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
