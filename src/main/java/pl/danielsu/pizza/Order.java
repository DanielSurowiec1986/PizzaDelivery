package pl.danielsu.pizza;

import pl.danielsu.pizza.item.Item;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final Customer customer;
    List<Item> orderedItems = new ArrayList<>();

    public Order(Customer customer) {
        this.customer = customer;
    }

    public String getCustomer() {
        return customer.getName();
    }

    public void getConsumerOrder(){
        System.out.println("Customer "+getCustomer()+" ordered: ");
        for (int i = 0; i < orderedItems.size(); i++) {
            System.out.println(orderedItems.get(i).getItemDescription());
        }

    }
    public void addItemToOrder(Item item){
        orderedItems.add(item);
    }
}
