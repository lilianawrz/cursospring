package com.awis.cursospring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.awis.cursospring.entities.User;
import com.awis.cursospring.repositories.UserRepository;
import com.awis.cursospring.services.exceptions.DatabaseException;
import com.awis.cursospring.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {
	@Autowired
	private UserRepository repository;

	// retornar todos os usuários do banco

	public List<User> findAll() {
		return repository.findAll();
	}
	// retorna o usuário por id

	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

//User insert
	public User insert(User obj) {
		return repository.save(obj);
	}

	// User delete
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
	public User update(Long id, User obj) {
		try {
		User entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
		}catch(EntityNotFoundException e ) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());

	}
}
