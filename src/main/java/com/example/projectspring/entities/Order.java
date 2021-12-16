package com.example.projectspring.entities;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name= "tb_order")
public class Order {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	private Instant moment;
	private OrderStatus status;
	
	@JsonIgnore				// Por ser uma via de mão dupla usamos essa anotação 			
	@ManyToOne							//Muitos order -para-1 Client	///Nome da chave estrangenheira(na tabela do meu banco "Tb_order" 
	@JoinColumn(name = "clint_id")							  		   //vai ter agora um campo chamado "client_id" que vai ser o Id Do client que fez esse pedido
	private Client client;    	  	//Atributo de referencia
	
	@OneToMany(mappedBy="order")
	private List<OrderItem> items = new ArrayList<>();   // Um "order" vai ter varios "orderItem " 
	
	public Order() {
		
	}

	public Order(Long id, Instant moment, OrderStatus status, Client client) {
		super();
		this.id = id;
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public double getTotal() {
		
		Double sum = 0.0;
		for (OrderItem orderItem : items) {
			sum = sum + orderItem.getSubTotal();
		}
		return sum;
	
	}

}
