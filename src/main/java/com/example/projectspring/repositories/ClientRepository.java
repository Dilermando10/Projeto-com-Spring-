package com.example.projectspring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projectspring.entities.Client;

public interface ClientRepository extends  JpaRepository<Client, Long>{

}
