package com.coffeeshop.coffeeshop.Coffee;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.coffeeshop.coffeeshop.Order.Orders;

@Entity
@Table
public class Coffee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Coffee_SEQ")
    Long id;
    String name;
    double price;

    @ManyToMany(mappedBy = "coffee")
    private List<Orders> orders;

    public Coffee() {
    }

    public Coffee(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Coffee(Long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public void updateCoffee(Coffee c) {
        this.name = c.name;
        this.price = c.price;
    }

    public Long getId() {
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
