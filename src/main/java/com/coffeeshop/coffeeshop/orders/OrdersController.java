package com.coffeeshop.coffeeshop.orders;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/order")
public class OrdersController {

    private final OrdersService ordersService;

    @Autowired
    public OrdersController(OrdersService coffeeService) {
        this.ordersService = coffeeService;
    }

    @GetMapping
    List<Order> getALlOrders() {
        return ordersService.getAllOrders();
    }

    @GetMapping("/{id}")
    ResponseEntity<Optional<Order>> getOrdersById(@PathVariable Long id) {
        Optional<Order> c = ordersService.getOrderById(id);
        if (c.isPresent()) {
            return new ResponseEntity<>(c, HttpStatus.FOUND);
        }
        return new ResponseEntity<>(Optional.empty(), HttpStatus.NOT_FOUND);
    }

}
