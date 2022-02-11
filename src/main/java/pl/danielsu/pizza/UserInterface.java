package pl.danielsu.pizza;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import pl.danielsu.pizza.item.*;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class UserInterface {


    private static String[] options = {"1 - Show me the menu", "2 - Show me some sample orders", "3 - Show me the order generator", "4 - Close App"};

    public static String[] getOptions() {
        return options;
    }
    public static int displayInterface() {
        int numberOfOptions = getOptions().length;
        printOptions();
        Scanner scanner = new Scanner(System.in);
        int numberOfChoose = scanner.nextInt();

        do {
            if (numberOfChoose > numberOfOptions) {
                System.out.println("An invalid character was entered. Try one more time.");
                printOptions();
                numberOfChoose = scanner.nextInt();
            }
        } while (numberOfChoose > numberOfOptions);
        return numberOfChoose;
    }

    public static void printOptions() {
        System.out.println("Choose an action:");

        for (int i = 0; i < options.length; i++) {
            System.out.println(options[i]);
        }
        System.out.println("What is your choice (number):");
    }




    public static void doChoosedAction(int numberOfChoose) throws IOException {
        switch (numberOfChoose) {
            case 1:
                //show all menu
                MenuGenerator menuGenerator = new MenuGenerator();
                menuGenerator.getAllMenu();
                break;
            case 2:
                //show sample orders
                UserInterface.getSampleOrder();
                break;
            case 3:
                //generate orders
                UserInterface.getAutomaticOrders();
                break;
            case 4:
                System.out.println("App has been closed");
                break;
            default:
                System.out.println("An invalid character was entered.");
        }
    }


    private static void getAutomaticOrders() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of orders to generate:");
        int numberOfOrders = scanner.nextInt();

        OrderGenerator orderGenerator = new OrderGenerator();

        //save order to json file
        Order[] newOrder = orderGenerator.generateOrder(numberOfOrders);

        Writer writer = new FileWriter("order.json");
        Gson gson = new GsonBuilder().create();
        gson.toJson(newOrder, writer);
        writer.flush();
        writer.close();

        for (Order order : newOrder) {
            System.out.println("----------------------");
            order.getConsumerOrder();
            System.out.println("----------------------");
        }
    }

    private static void getSampleOrder() {
        Customer customer1 = new Customer("Zenek", "Łąkowa 11E", "608 250 250");
        Order order1 = new Order(customer1);
        order1.addItemToOrder(new Pizza(PizzaType.PEPPERONI, PizzaSize.LARGE));
        order1.addItemToOrder(new Drink(DrinkType.SOK));
        order1.addItemToOrder(new Drink(DrinkType.SOK));
        order1.getConsumerOrder();
        Customer customer2 = new Customer("Krysia", "Nadrzeczna 6/3", "516 255 255");
        Order order2 = new Order(customer2);
        order2.addItemToOrder(new Pizza(PizzaType.DIAVOLA, PizzaSize.SMALL));
        order2.addItemToOrder(new Pizza(PizzaType.CAPRICCIOSA, PizzaSize.MEDIUM));
        order2.addItemToOrder(new Drink(DrinkType.COLA));
        order2.getConsumerOrder();
        Customer customer3 = new Customer("Antoni", "Polna 13", "608 959 323");
        Order order3 = new Order(customer3);
        order3.addItemToOrder(new Hamburger());
        order3.addItemToOrder(new Drink(DrinkType.PIWO));
        order3.getConsumerOrder();
    }
}

