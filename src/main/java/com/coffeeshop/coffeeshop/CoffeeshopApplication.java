package com.coffeeshop.coffeeshop;

import java.util.ArrayList;
import java.util.List;

import com.coffeeshop.coffeeshop.Coffee.Coffee;
import com.coffeeshop.coffeeshop.Coffee.CoffeeRepository;
import com.coffeeshop.coffeeshop.Employee.Employee;
import com.coffeeshop.coffeeshop.Employee.EmployeeRepository;
import com.coffeeshop.coffeeshop.Order.Orders;
import com.coffeeshop.coffeeshop.Order.OrdersRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication

public class CoffeeshopApplication {
	public static void main(String[] args) {
		SpringApplication.run(CoffeeshopApplication.class, args);

	}

	@Bean
	CommandLineRunner commandLineRunner(
			CoffeeRepository coffeeRepository,
			EmployeeRepository employeeRepository,
			OrdersRepository ordersRepository) {
		return args -> {

			List<Coffee> coffees = new ArrayList<>();

			coffees.add(new Coffee("Latte", 18));
			coffees.add(new Coffee("Black Coffee", 18));
			coffees.add(new Coffee("Tea", 18));
			coffees.add(new Coffee("Black Tea", 18));
			coffees.add(new Coffee("Green Tea", 18));

			coffeeRepository.saveAll(coffees);

			List<Employee> employees = new ArrayList<>();

			employees.add(new Employee("Khalid"));
			employees.add(new Employee("Ahmed"));
			employees.add(new Employee("Ali"));
			employeeRepository.saveAll(employees);

			List<Orders> orders = new ArrayList<Orders>();

			orders.add(new Orders(employees.get(0), coffees));
			orders.add(new Orders(employees.get(1), coffees));
			orders.add(new Orders(employees.get(2), coffees));

			// ordersRepository.saveAll(orders);

		};

	}

}
