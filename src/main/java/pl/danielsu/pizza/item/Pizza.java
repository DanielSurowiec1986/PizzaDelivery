package pl.danielsu.pizza.item;

import java.util.Objects;

public class Pizza implements Item {
    private final String name;
    private final String size;

    public Pizza(PizzaType type, PizzaSize size) {
        this.name = "Pizza: " + type.name();
        this.size = size.name();
    }


    @Override
    public String getItemDescription() {
        return name + "/Size: " + size;
    }
}
