package com.awis.cursospring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.awis.cursospring.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
