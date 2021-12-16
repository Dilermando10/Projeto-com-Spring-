package com.example.projectspring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projectspring.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
