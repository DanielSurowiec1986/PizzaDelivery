package pl.danielsu.pizza;

import pl.danielsu.pizza.item.DrinkType;
import pl.danielsu.pizza.item.Hamburger;
import pl.danielsu.pizza.item.PizzaSize;
import pl.danielsu.pizza.item.PizzaType;

public class MenuGenerator {

    public void getPizzaMenu() {
        System.out.println("Pizza:");
        for (int i = 0; i < PizzaType.values().length; i++) {
            for (int j = 0; j < PizzaSize.values().length; j++) {
                System.out.println(PizzaType.values()[i] + "/Size:" + PizzaSize.values()[j]);

            }
        }
    }
    public void getDrinkMenu() {
        System.out.println("Drinks:");
        for (int i = 0; i < DrinkType.values().length; i++) {
                System.out.println(DrinkType.values()[i]);
        }
    }
    public void getHamburgerMenu(){
        System.out.println(new Hamburger().getItemDescription());
    }
    public void getAllMenu(){
        System.out.println(">>>>>>>>MENU<<<<<<<<");
        getPizzaMenu();
        System.out.println("--------------------");
        getDrinkMenu();
        System.out.println("--------------------");
        System.out.println("Other:");
        getHamburgerMenu();
        System.out.println(">>>>>>>>>><<<<<<<<<<");
    }
}
