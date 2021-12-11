package com.coffeeshop.coffeeshop;

import java.util.ArrayList;
import java.util.List;

import com.coffeeshop.coffeeshop.coffee.Coffee;
import com.coffeeshop.coffeeshop.coffee.CoffeeRepository;
import com.coffeeshop.coffeeshop.employee.Employee;
import com.coffeeshop.coffeeshop.employee.EmployeeRepository;
import com.coffeeshop.coffeeshop.orders.Order;
import com.coffeeshop.coffeeshop.orders.OrdersRepository;

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

			// List<Story> storyList = new ArrayList<>();
			// // create first story
			// Story story1 = new Story();
			// story1.setStoryName("Arrays");
			// // create second story
			// Story story2 = new Story();
			// story2.setStoryName("Pointers");
			// // create third story
			// Story story3 = new Story();
			// story3.setStoryName("Loops");
			// // add all story into storyList. Till here we have prepared data for
			// OneToMany
			// storyList.add(story1);
			// storyList.add(story2);
			// storyList.add(story3);
			// // Prepare data for ManyToOne
			// story1.setBook(book);
			// story2.setBook(book);
			// story3.setBook(book);
			// book.setStoryList(storyList);
			// book = bookRepository.save(book);

			Employee employee1 = new Employee("Khalid");
			Employee employee2 = new Employee("Ahmed");

			List<Coffee> coffees = new ArrayList<>();
			coffees.add(new Coffee("Latte", 18));
			coffees.add(new Coffee("Black Coffee", 18));
			coffees.add(new Coffee("Tea", 18));
			coffees.add(new Coffee("Black Tea", 18));
			coffees.add(new Coffee("Green Tea", 18));

			// employee1.setCoffees(coffees);

			// coffees.get(0).setEmployee(employee1);
			// coffees.get(1).setEmployee(employee1);
			// coffees.get(2).setEmployee(employee1);
			// coffees.get(3).setEmployee(employee1);

			coffeeRepository.saveAll(coffees);

			Order order1 = new Order();
			order1.setCoffees(coffees);
			order1.setEmployee(employee1);
			// Order order2 = new Order();
			// order2.setEmployee(employee1);

			ordersRepository.save(order1);
			// ordersRepository.save(order2);

			// List<Employee> employees = new ArrayList<>();

			// employees.add(new Employee("Khalid", coffees));
			// employees.add(new Employee("Ahmed", coffees));
			// employees.add(new Employee("Ali", coffees));
			employeeRepository.save(employee1);
			employeeRepository.save(employee2);

			// List<Orders> orders = new ArrayList<Orders>();

			// orders.add(new Orders(employees.get(0), coffees));
			// orders.add(new Orders(employees.get(1), coffees));
			// orders.add(new Orders(employees.get(2), coffees));

			// ordersRepository.saveAll(orders);

		};

	}

}
