package Excercises.javase020.filteringandmapping;

import java.util.*;

// Order.java
class Order {
    String customer;
    List<String> items;
    double total;

    Order(String customer, List<String> items, double total) {
        this.customer = customer;
        this.items = items;
        this.total = total;
    }

    public String toString() {
        return customer + " - $" + total + " - " + items;
    }
}