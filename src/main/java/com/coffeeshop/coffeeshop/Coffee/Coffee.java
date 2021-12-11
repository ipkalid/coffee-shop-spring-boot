package com.coffeeshop.coffeeshop.coffee;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "coffee")
public class Coffee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Coffee_SEQ")
    Long id;
    @Column(name = "coffee_name")
    String name;
    @Column(name = "coffee_price")
    double price;

    // @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    // @JoinColumn(name = "employee_id", referencedColumnName = "id")
    // @JsonIgnoreProperties("coffees")
    // private Employee employee;

    public Coffee() {

    }

    public Coffee(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // public Employee getEmployee() {
    // return employee;
    // }

    // public void setEmployee(Employee employee) {
    // this.employee = employee;
    // }

    @Override
    public String toString() {
        return "Coffee [id=" + id + ", name=" + name + ", price=" + price + "]";
    }

}
