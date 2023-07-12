package com.awis.cursospring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.awis.cursospring.entities.Category;
import com.awis.cursospring.repositories.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository repository;

	// retornar todos os usuários do banco

	public List<Category> findAll() {
		return repository.findAll();
	}
	// retorna o usuário por id

	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get();
	}

}
