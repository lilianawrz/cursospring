package com.awis.cursospring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.awis.cursospring.entities.User;
import com.awis.cursospring.repositories.UserRepository;

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
		return obj.get();
	}

//User insert
	public User insert(User obj) {
		return repository.save(obj);
	}
	//User delete
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
