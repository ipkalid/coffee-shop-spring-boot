package com.coffeeshop.coffeeshop.Order;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/orders")
public class OrdersController {

    private final OrdersService coffeeService;

    @Autowired
    public OrdersController(OrdersService coffeeService) {
        this.coffeeService = coffeeService;
    }

    @GetMapping
    void getOrders() {
        System.out.println("HERE");
        coffeeService.getAllOrders();
    }

    @GetMapping("/{id}")
    ResponseEntity<Optional<Orders>> getOrdersById(@PathVariable Long id) {
        Optional<Orders> c = coffeeService.getOrdersById(id);
        if (c.isPresent()) {
            return new ResponseEntity<>(c, HttpStatus.FOUND);
        }
        return new ResponseEntity<>(Optional.empty(), HttpStatus.NOT_FOUND);
    }

    @PostMapping()
    public ResponseEntity<Orders> postNewOrders(@RequestBody Orders o) {
        Orders newOrders = coffeeService.addNewOrders(o);
        return new ResponseEntity<>(newOrders, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Optional<String>> deleteOrdersById(@PathVariable Long id) {
        if (coffeeService.removeOrders(id)) {
            return new ResponseEntity<>(Optional.of("Deleted"), HttpStatus.OK);
        }
        return new ResponseEntity<>(Optional.of("Not Found"), HttpStatus.NOT_FOUND);
    }

}
