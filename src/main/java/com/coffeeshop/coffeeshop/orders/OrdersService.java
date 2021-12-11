package com.coffeeshop.coffeeshop.orders;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersService {

    private final OrdersRepository ordersRepository;

    @Autowired
    public OrdersService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    List<Order> getAllOrders() {

        return ordersRepository.findAll();
    }

    Optional<Order> getOrderById(Long id) {
        return ordersRepository.findById(id);
    }

    boolean removeOrder(Long id) {
        if (ordersRepository.existsById(id)) {
            ordersRepository.deleteById(id);
            return true;
        }
        return false;
    }

}