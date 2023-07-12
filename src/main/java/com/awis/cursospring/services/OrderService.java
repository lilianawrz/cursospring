package com.awis.cursospring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.awis.cursospring.entities.Order;
import com.awis.cursospring.repositories.OrderRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository repository;

	// retornar todos os pedidos do banco

	public List<Order> findAll() {
		return repository.findAll();
	}
	// retorna os pedidos por id

	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}

}
