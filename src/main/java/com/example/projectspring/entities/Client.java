package com.example.projectspring.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_client")
public class Client {

														 
	@Id													//a JPA passará a utilizar a geração de chave primária 
	@GeneratedValue(strategy = GenerationType.IDENTITY)	//do banco de dados ao qual a aplicação está conectada.
	private Long id;
	private String name;
	private String email;
	
	public Client() {
	}

	public Client(Long id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}