package com.coffeeshop.coffeeshop.orders;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.coffeeshop.coffeeshop.coffee.Coffee;
import com.coffeeshop.coffeeshop.employee.Employee;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "orders")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Orders_SEQ")
    Long id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    @JsonIgnoreProperties("orders")
    private Employee employee;

    @ManyToMany
    @JoinTable(name = "order_detail", joinColumns = @JoinColumn(name = "coffee_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "orders_id", referencedColumnName = "id"))
    private Collection<Coffee> coffees;

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("approved_by")
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @JsonProperty("order_details")
    public Collection<Coffee> getCoffees() {
        return coffees;
    }

    public void setCoffees(Collection<Coffee> coffees) {
        this.coffees = coffees;
    }

    public void setApprovedByEmployee(Employee approvedByEmployee) {
        this.employee = approvedByEmployee;
    }

}
