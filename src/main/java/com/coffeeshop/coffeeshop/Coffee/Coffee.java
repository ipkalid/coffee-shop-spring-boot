package com.coffeeshop.coffeeshop.Coffee;

import java.util.UUID;

public class Coffee {
    final String id;
    String name;
    double price;

    public Coffee(String name, double price) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.price = price;
    }

    public void updateCoffee(Coffee c) {
        this.name = c.name;
        this.price = c.price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Coffee [id=" + id + ", name=" + name + ", price=" + price + "]";
    }

}
