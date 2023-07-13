package com.awis.cursospring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.awis.cursospring.entities.Product;
import com.awis.cursospring.repositories.ProductRepository;
import com.awis.cursospring.services.exceptions.DatabaseException;
import com.awis.cursospring.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

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

	//Product insert
		public Product insert(Product obj) {
			return repository.save(obj);
		}

		// Product delete
		public void delete(Long id) {
			try {
				repository.deleteById(id);
			} catch (EmptyResultDataAccessException e) {
				throw new ResourceNotFoundException(id);

			} catch (DataIntegrityViolationException e) {
				throw new DatabaseException(e.getMessage());

			}
		}

		// User update
		public Product update(Long id, Product obj) {
			try {
			Product entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
			}catch(EntityNotFoundException e ) {
				throw new ResourceNotFoundException(id);
			}
		}

		private void updateData(Product entity, Product obj) {
			entity.setName(obj.getName());
	    	entity.setDescription(obj.getDescription());
	    	entity.setPrice(obj.getPrice());
	    	entity.setImgUrl(obj.getImgUrl());

		}
}
