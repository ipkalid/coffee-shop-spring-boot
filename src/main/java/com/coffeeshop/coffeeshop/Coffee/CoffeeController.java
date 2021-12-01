package com.coffeeshop.coffeeshop.Coffee;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/coffee")
public class CoffeeController {
    List<Coffee> coffees;

    CoffeeController() {
        coffees = new ArrayList<Coffee>();
        coffees.addAll(List.of(
                new Coffee("Americano", 19.99), new Coffee("Cappuccino", 19.99),
                new Coffee("Latte", 19.99)));
    }

    @GetMapping
    List<Coffee> getCoffees() {
        return coffees;
    }

    @GetMapping("/{id}")
    ResponseEntity<Optional<Coffee>> getCoffeeById(@PathVariable String id) {
        for (Coffee coffee : coffees) {
            for (int i = 0; i < coffees.size(); i++) {
                if (id.equals(coffees.get(i).id)) {
                    return new ResponseEntity<>(Optional.of(coffee), HttpStatus.OK);
                }
            }

        }
        return new ResponseEntity<>(Optional.empty(), HttpStatus.NOT_FOUND);
    }

    @PostMapping()
    public ResponseEntity<Coffee> postNewCoffee(@RequestBody Coffee c) {
        coffees.add(c);
        return new ResponseEntity<>(c, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    ResponseEntity<Optional<Coffee>> putCoffee(
            @PathVariable String id,
            @RequestBody Coffee c) {

        for (int i = 0; i < coffees.size(); i++) {
            if (id.equals(coffees.get(i).id)) {
                coffees.get(i).updateCoffee(c);
                return new ResponseEntity<>(Optional.of(coffees.get(i)), HttpStatus.OK);
            }
        }

        return new ResponseEntity<>(Optional.empty(), HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Optional<String>> deleteCoffeeById(@PathVariable String id) {
        for (int i = 0; i < coffees.size(); i++) {
            if (id.equals(coffees.get(i).id)) {
                coffees.remove(i);
                return new ResponseEntity<>(Optional.of("Deleted"), HttpStatus.ACCEPTED);
            }
        }

        return new ResponseEntity<>(Optional.of("Not Found"), HttpStatus.NOT_FOUND);
    }

}
