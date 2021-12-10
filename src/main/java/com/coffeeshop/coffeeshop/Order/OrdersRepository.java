package com.coffeeshop.coffeeshop.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {
    // @Query("SELECT o FROM Orders s WHERE s.email = ?1")
    // Optional<Orders> findStudentByEmail(String email);
}