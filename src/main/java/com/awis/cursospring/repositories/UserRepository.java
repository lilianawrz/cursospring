package com.awis.cursospring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.awis.cursospring.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
