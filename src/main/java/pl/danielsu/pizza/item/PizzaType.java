package pl.danielsu.pizza.item;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum PizzaType {
    PEPPERONI, CAPRICCIOSA, DIAVOLA;

    private static final List<PizzaType> VALUES =
            Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static PizzaType randomPizzaType() {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
