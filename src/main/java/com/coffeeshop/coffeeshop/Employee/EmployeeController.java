package com.coffeeshop.coffeeshop.employee;

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
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService coffeeService) {
        this.employeeService = coffeeService;
    }

    @GetMapping
    List<Employee> getEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable Long id) {
        Optional<Employee> c = employeeService.getEmployeeById(id);
        if (c.isPresent()) {
            return new ResponseEntity<>(c, HttpStatus.FOUND);
        }
        return new ResponseEntity<>(Optional.empty(), HttpStatus.NOT_FOUND);
    }

    @PostMapping()
    public ResponseEntity<Employee> postNewEmployee(@RequestBody Employee e) {
        Employee newEmployee = employeeService.addNewEmployees(e);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    ResponseEntity<Optional<Employee>> putEmployee(
            @PathVariable Long id,
            @RequestBody Employee c) {

        Optional<Employee> result = employeeService.editEmployeeById(id, c);

        return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Optional<String>> deleteEmployeeById(@PathVariable Long id) {
        if (employeeService.removeEmployee(id)) {
            return new ResponseEntity<>(Optional.of("Deleted"), HttpStatus.OK);
        }
        return new ResponseEntity<>(Optional.of("Not Found"), HttpStatus.NOT_FOUND);
    }

}
