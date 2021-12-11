package com.coffeeshop.coffeeshop.coffee;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

    private final CoffeeService coffeeService;

    @Autowired
    public CoffeeController(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
    }

    @GetMapping
    List<Coffee> getCoffees() {
        return coffeeService.getAllCoffees();
    }

    @GetMapping("/{id}")
    ResponseEntity<Optional<Coffee>> getCoffeeById(@PathVariable Long id) {
        Optional<Coffee> c = coffeeService.getCoffeeById(id);
        if (c.isPresent()) {
            return new ResponseEntity<>(c, HttpStatus.FOUND);
        }
        return new ResponseEntity<>(Optional.empty(), HttpStatus.NOT_FOUND);
    }

    @PostMapping()
    public ResponseEntity<Coffee> postNewCoffee(@RequestBody Coffee c) {
        Coffee newCoffee = coffeeService.addNewCoffees(c);
        return new ResponseEntity<>(newCoffee, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    ResponseEntity<Optional<Coffee>> putCoffee(
            @PathVariable Long id,
            @RequestBody Coffee c) {

        Optional<Coffee> result = coffeeService.editCoffeeById(id, c);

        return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Optional<String>> deleteCoffeeById(@PathVariable Long id) {
        if (coffeeService.removeCoffee(id)) {
            return new ResponseEntity<>(Optional.of("Deleted"), HttpStatus.OK);
        }
        return new ResponseEntity<>(Optional.of("Not Found"), HttpStatus.NOT_FOUND);
    }

}
