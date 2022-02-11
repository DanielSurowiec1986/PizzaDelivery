package pl.danielsu.pizza.item;

public class Drink implements Item{
    private final String name;

    public Drink(DrinkType type) {
        this.name = type.name();
    }

    @Override
    public String getItemDescription() {
        return name;
    }
}
