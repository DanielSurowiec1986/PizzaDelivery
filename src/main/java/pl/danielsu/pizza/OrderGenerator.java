package pl.danielsu.pizza;

import pl.danielsu.pizza.item.*;

import java.util.Random;

public class OrderGenerator {

    public Order[] generateOrder(int numberOfOrders) {
        Random r = new Random();
        Customer[] customers = new Customer[numberOfOrders];
        String[] randomsNames = {"Andrzej", "Zenek", "Krysia", "Ania", "Krysia", "Franek", "Ewa", "Antoni"};
        String[] randomsAddresses = {"Łąkowa 11E", "Nadrzeczna 6/3", "Polna 13", "Hestii 1", "Jelitkowska 51", "Pomorska 15"};
        String[] randomsPhoneNo = {"666 232 565", "601 858 323", "808 789 654", "601 897 555", "608 555 666", "506 556 988"};
        int counter = 0;
        for (int i = 0; i < numberOfOrders; i++) {
            int randomNameNumber = r.nextInt(randomsNames.length);
            int randomAddressNumber = r.nextInt(randomsAddresses.length);
            int randomPhoneNoNumber = r.nextInt(randomsPhoneNo.length);
            Customer newCustomer = new Customer(randomsNames[randomNameNumber], randomsAddresses[randomAddressNumber], randomsPhoneNo[randomPhoneNoNumber]);
            if (i > 0 && newCustomer.equals(customers[i - 1]) && newCustomer.hashCode() == customers[i - 1].hashCode()) {
                //this customer exists, set next
                counter+=1;
                newCustomer = new Customer(randomsNames[randomNameNumber], randomsAddresses[randomAddressNumber], randomsPhoneNo[randomPhoneNoNumber]);
            }
            customers[i] = newCustomer;

        }

        if (counter>0){
            System.out.println("The draw of "+counter+" customers was repeated");
        }

        Order[] orders = new Order[numberOfOrders];
        for (int i = 0; i < numberOfOrders; i++) {
            orders[i] = new Order(customers[i]);
        }
        for (int i = 0; i < orders.length; i++) {
            int numberOfItems = (new Random()).nextInt(5) + 1;
            int itemNumber = (new Random()).nextInt(3) + 1;
            for (int j = 0; j < numberOfItems; j++) {
                switch (itemNumber) {
                    case 1:
                        //add pizza
                        orders[i].addItemToOrder(new Pizza(PizzaType.randomPizzaType(), PizzaSize.randomPizzaSize()));
                        break;
                    case 2:
                        //add drink
                        orders[i].addItemToOrder(new Drink(DrinkType.randomDrinkType()));
                        break;
                    case 3:
                        //add hamburger
                        orders[i].addItemToOrder(new Hamburger());
                        break;
                }

            }

        }
        return orders;

    }
}
