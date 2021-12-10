package com.coffeeshop.coffeeshop.Order;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersService {

    private final OrdersRepository ordersRepository;

    @Autowired
    public OrdersService(OrdersRepository coffeeRepository) {
        this.ordersRepository = coffeeRepository;
    }

    void getAllOrders() {
        System.out.println("HHHHH");
        var coffees = ordersRepository.findById((long) 1);

        System.out.println(coffees);
        // return ordersRepository.findAll();
    }

    Optional<Orders> getOrdersById(Long id) {
        return ordersRepository.findById(id);
    }

    Orders addNewOrders(Orders c) {
        return ordersRepository.save(c);
    }

    // Optional<Orders> editOrdersById(Long id, Orders c) {
    // if (coffeeRepository.existsById(id)) {
    // Orders chosenOrders = coffeeRepository.getById(id);
    // chosenOrders.setName(c.name);
    // return Optional.of(coffeeRepository.save(chosenOrders));
    // }

    // return Optional.empty();
    // }

    boolean removeOrders(Long id) {
        if (ordersRepository.existsById(id)) {
            ordersRepository.deleteById(id);
            return true;
        }
        return false;
    }

}