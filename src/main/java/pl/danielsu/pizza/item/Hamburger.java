package pl.danielsu.pizza.item;

public class Hamburger implements Item{
    private final String name = "HAMBURGER";

    @Override
    public String getItemDescription() {
        return name;
    }
}
