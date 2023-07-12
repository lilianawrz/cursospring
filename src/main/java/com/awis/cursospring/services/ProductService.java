package com.awis.cursospring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.awis.cursospring.entities.Product;
import com.awis.cursospring.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository repository;

	// retornar todos os usuários do banco

	public List<Product> findAll() {
		return repository.findAll();
	}
	// retorna o usuário por id

	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get();
	}

}
