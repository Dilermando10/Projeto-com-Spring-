package com.example.projectspring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projectspring.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
