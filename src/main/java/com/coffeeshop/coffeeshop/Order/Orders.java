package com.coffeeshop.coffeeshop.Order;

import java.io.Serializable;
import java.util.List;

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

import com.coffeeshop.coffeeshop.Coffee.Coffee;
import com.coffeeshop.coffeeshop.Employee.Employee;

@Entity
@Table
public class Orders implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Orders_SEQ")
    Long id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "employee_id", nullable = false)
    Employee approvedByEmployee;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "coffee_orders", joinColumns = @JoinColumn(name = "coffee_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "orders_id", referencedColumnName = "id"))
    List<Coffee> coffees;

    public Orders() {
    }

    public Orders(Employee approvedByEmployee, List<Coffee> coffees) {

        this.approvedByEmployee = approvedByEmployee;
        this.coffees = coffees;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employee getApprovedByEmployee() {
        return approvedByEmployee;
    }

    public void setApprovedByEmployee(Employee approvedByEmployee) {
        this.approvedByEmployee = approvedByEmployee;
    }

}
