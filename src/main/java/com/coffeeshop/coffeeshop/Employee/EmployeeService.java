package com.coffeeshop.coffeeshop.employee;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepository coffeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    List<Employee> getAllEmployees() {
        return coffeeRepository.findAll();
    }

    Optional<Employee> getEmployeeById(Long id) {
        return coffeeRepository.findById(id);
    }

    Employee addNewEmployees(Employee c) {
        return coffeeRepository.save(c);
    }

    Optional<Employee> editEmployeeById(Long id, Employee c) {
        if (coffeeRepository.existsById(id)) {
            Employee chosenEmployee = coffeeRepository.getById(id);
            chosenEmployee.setName(c.name);
            return Optional.of(coffeeRepository.save(chosenEmployee));
        }

        return Optional.empty();
    }

    boolean removeEmployee(Long id) {
        if (coffeeRepository.existsById(id)) {
            coffeeRepository.deleteById(id);
            return true;
        }
        return false;
    }

}